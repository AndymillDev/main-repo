package com.example.trymagazine2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemCardActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_layout);

        TextView tv = findViewById(R.id.textView);
        ImageView im = findViewById(R.id.view_image_drawable);
        String textName = getIntent().getStringExtra("something");
        tv.setText(textName);

        Bitmap bitmap = (Bitmap)getIntent().getParcelableExtra("Bitmap");
        //String imageName = getIntent().getStringExtra("imageExtra");
        //int resID = getResources().getIdentifier(imageName , "drawable", getPackageName());
        im.setImageBitmap(bitmap);
    }
}
