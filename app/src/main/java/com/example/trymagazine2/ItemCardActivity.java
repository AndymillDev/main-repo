package com.example.trymagazine2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ItemCardActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_layout);

        TextView tv = findViewById(R.id.textView);
        String text = getIntent().getStringExtra("something");
        tv.setText(text);
    }
}
