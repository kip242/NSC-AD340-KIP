package com.example.kip.ad340project;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.support.v4.app.DialogFragment;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    public static final String EXTRA_MESSAGE = "com.example.kip.assignment2.MESSAGE";
    private static final String TAG = DisplayMessageActivity.class.getSimpleName();

    String[] btn_values = {"Display Image", "Button 2", "Button 3", "Button 4"};
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);//creates layout, maybe change back to activity_main

        context = getApplicationContext();
        Log.d(TAG, "onCreate()");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create dialog and show on FAB click
                DialogFragment newFragment = new PickColorDialogFragment();
                newFragment.show(getSupportFragmentManager(), "color");
            }
        });

        //create gridview and show toast when item clicked
        GridView gridview = (GridView) findViewById(R.id.gridview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, btn_values);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * Function call when "SEND" is pressed
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    //switch case to handle option selection on toolbar menu
    public boolean onOptionsItemSelected(MenuItem item){
      switch(item.getItemId()){
          case R.id.app_bar_about:
              Intent goToAboutActivity = new Intent(getBaseContext(), AboutActivity.class);
              startActivity(goToAboutActivity);
              return true;
          case R.id.app_bar_recyclerview:
              Intent goToRecyclerActivity = new Intent(getBaseContext(), RecyclerActivity.class);
              startActivity(goToRecyclerActivity);
              return true;
          case R.id.app_bar_webrecyclerview:
              Intent goToWebRecyclerActivity = new Intent(getBaseContext(), RecyclerWebActivity.class);
              startActivity(goToWebRecyclerActivity);
              return true;
          case R.id.app_bar_location:
              Intent goToGetCurrentLocation = new Intent(getBaseContext(), GetCurrentLocation.class);
              startActivity(goToGetCurrentLocation);
              return true;
          default:
              return super.onOptionsItemSelected(item);
      }
    }
}


