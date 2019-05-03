package com.example.lesson3framelayoutandimageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            buildLegacyScaling();
        }
    }

    /**
     * Правильное масштабирование для старых версий.
     */
    private void buildLegacyScaling() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        float pxWidth = metrics.widthPixels;

        ImageView imgVu = findViewById(R.id.main_image);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.smile384x384);
        int nuHeight = (int) (bmp.getHeight() * (pxWidth / bmp.getWidth()));
        Bitmap scaled = Bitmap.createScaledBitmap(bmp, (int) pxWidth, nuHeight, true);
        imgVu.setImageBitmap(scaled);
        Toast.makeText(this, "For older: screen width = " + pxWidth, Toast.LENGTH_SHORT).show();
    }

}
