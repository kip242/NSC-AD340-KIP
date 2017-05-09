package com.example.kip.ad340project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FabActivity extends AppCompatActivity {
    private static final String TAG = FabActivity.class.getSimpleName();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fab_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = getApplicationContext();

        //click "Go To Gridview" Button
        /*Button button = (Button) findViewById(R.id.fabButton1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent goToGridview = new Intent(getBaseContext(), GridviewActivity.class);
                startActivity(goToGridview);
            }
        });*/
    }

    //record onStart to Logcat
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }
}
