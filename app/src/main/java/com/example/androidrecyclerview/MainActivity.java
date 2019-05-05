package com.example.androidrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] names = new String[100];
            for (int i = 0; i < names.length; i++) {
                names[i] = "Item #" + i;
            }

        final RecyclerView recyclerView = findViewById(R.id.view_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ListAdapter(this, names));
    }

    private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        final LayoutInflater mLayoutInflater;
        private final String[] mData;

        public ListAdapter(Context context, String[] data) {
            mLayoutInflater = LayoutInflater.from(context);
            mData = data;
        }


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
