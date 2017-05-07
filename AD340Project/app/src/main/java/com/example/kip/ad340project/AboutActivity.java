package com.example.kip.ad340project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;



public class AboutActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        context = getApplicationContext();

        //create and display toolbar with back navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView) findViewById(R.id.aboutView);
        String about = "This is a conversion app.  This app will allow you to do various types of " +
                "conversion.  You will be able to do distance, measurement, and temperature conversions.";

        textView.setText(about);
    }
}
