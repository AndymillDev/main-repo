package com.example.trymagazine2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<Drawable> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageList(this);
    }

    public void initImageList(Context context) {

        mNames.add("comfort_2");
        mNames.add("comfort_5");
        mNames.add("comfort_7");
        mNames.add("comfort_8");
        mNames.add("comfort_9");
        mNames.add("comfort_11");
        mNames.add("comfort_13");
        mNames.add("comfort_14");
        mNames.add("comfort_15");
        mNames.add("comfort_18");
        mNames.add("comfort_19");
        mNames.add("comfort_24");
        mNames.add("comfort_34");
        mNames.add("comfort_35");

        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));
        images.add(context.getResources().getDrawable(R.drawable.k5));

        initRecyclerView();
    }

    /*private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        mImageUrls.add("https://pandaufa.ru/upload/resize_cache/iblock/bcf/596_10000_1/bcf702224ac1b34f3c491b2701c996dc.jpg");
        mNames.add("Comfort 2");

        initRecyclerView();
    }*/

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, images, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
