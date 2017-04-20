package com.example.kip.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String TAG = DisplayMessageActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null){
            Log.d(TAG, "Restoring previous state");
        } else {
            Log.d(TAG, "No saved state available");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if (message != null){
            Log.d(TAG, "message sent to activity2");
        }
        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

    }
}
