package com.example.trymagazine;

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

public class MainActivity extends AppCompatActivity {

    private RecyclerView numberList;
    private NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberList = findViewById(R.id.recycler_view1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numberList.setLayoutManager(layoutManager);

        numberList.setHasFixedSize(true);

        numbersAdapter = new NumbersAdapter(100);
        numberList.setAdapter(numbersAdapter);
    }
}