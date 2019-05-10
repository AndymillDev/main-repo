package com.example.androidrecyclerview;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.view_progressbar);

        mRecyclerView = findViewById(R.id.view_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mListAdapter = new ListAdapter(this);
        mRecyclerView.setAdapter(mListAdapter);

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);

        findViewById(R.id.view_fab).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                Log.d("MainActivity", "Hello FAB!");
            }
        });

        new LoadGoogleReposTask().execute();
    }
        private List<String> getGoogleReposNames() {
            final List<String> names = new ArrayList<>();

            final URL url;
            try {
                url = new URL("https://api.github.com/users/google/repos");
            } catch (final MalformedURLException e) {
                throw new RuntimeException(e);
            }

            final HttpURLConnection urlConnection;
            final StringBuilder sb = new StringBuilder();
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                final BufferedReader reader =
                        new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                do {
                    line = reader.readLine();
                    sb.append(line);
                } while (line != null);
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
            urlConnection.disconnect();

            try {
                final JSONArray reposJsonArray = new JSONArray(sb.toString());
                for (int i = 0; i < reposJsonArray.length(); i++) {
                    names.add(reposJsonArray.getJSONObject(i).getString("name"));
                }
            } catch (final JSONException e) {
                throw new RuntimeException(e);
            }
            return names;
        }

    private class LoadGoogleReposTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(final Void... params) {
            final List<String> names = getGoogleReposNames();
            return names.toArray(new String[names.size()]);
        }

        @Override
        protected void onPostExecute(final String[] strings) {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);

            mListAdapter.setData(strings);
            mListAdapter.notifyDataSetChanged();
        }
    }

        private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        final LayoutInflater mLayoutInflater;
        private String[] mData;

        public ListAdapter(final Context context) {
            mLayoutInflater = LayoutInflater.from(context);}
            public void setData( final String[] data) {mData = data;}


        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
           final View view = mLayoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.textView.setText(mData[position]);
        }

        @Override
        public int getItemCount() {
            return mData.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;

            public ViewHolder(final View itemView) {
                super(itemView);

                textView = itemView.findViewById(android.R.id.text1);
            }



        }
    }
}
