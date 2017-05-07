package com.example.kip.ad340project;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;


public class ImageDisplay extends AppCompatActivity {
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = getApplicationContext();

        setContentView(R.layout.image_display_activity);
        //ImageView image = (ImageView) findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.download);

    }

}
