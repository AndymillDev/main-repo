package com.example.trymagazine2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemCardActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewAdapter";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_layout);
        Log.d(TAG, "onCreate itemCardActivity: started.");

        TextView tv = findViewById(R.id.textView);
        ImageView im = findViewById(R.id.view_image_drawable);
        String textName = getIntent().getStringExtra("something");
        tv.setText(textName);

        int i = textName.indexOf("_")+1;
        String imageName = textName.substring(i);
        int resID = getResources().getIdentifier("drawable/k" + imageName, null, getPackageName());
        Log.d(TAG, "Text name from intent: " + textName + " ResId: " + resID);
        im.setImageDrawable(this.getResources().getDrawable(resID));
    }
}
