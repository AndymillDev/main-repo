package com.example.trymagazine2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemCardActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewAdapter";
    String textName;
    int resID;
    int imageCount;
    GridLayout FieldLayout;
    RelativeLayout rl;
    TextView tv;
    ImageView im ;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_layout);
        Log.d(TAG, "onCreate itemCardActivity: started.");

        tv = findViewById(R.id.textView);
        im = findViewById(R.id.view_image_drawable);
        rl = findViewById(R.id.relative_layout_item);
        rl.removeView(tv);
        rl.removeView(im);


        Create(FieldLayout);
    }

    public void Create(View v) {

        imageCount = 5;

        FieldLayout = new GridLayout(this);
        FieldLayout.setColumnCount(imageCount);
        FieldLayout.setRowCount(imageCount);


        FieldLayout.addView(im,0);
        FieldLayout.addView(tv,1);
        rl.addView(FieldLayout);
        textName = getIntent().getStringExtra("something");
        tv.setText(textName);

        int i = textName.indexOf("_")+1;
        String imageName = textName.substring(i);
        resID = getResources().getIdentifier("drawable/k" + imageName, null, getPackageName());
        Log.d(TAG, "Text name from intent: " + textName + " ResId: " + resID);
        im.setImageDrawable(this.getResources().getDrawable(resID));
    }

}
