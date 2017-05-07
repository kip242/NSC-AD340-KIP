package com.example.kip.ad340project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;



public class GridviewActivity extends AppCompatActivity {

    String[] btn_values = {"Display Image", "Button 2", "Button 3", "Button 4"};
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_activity);//creates layout

        context = getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, btn_values);
        gridview.setAdapter(adapter);

        //this is previous assignment gridview code, I wanted to keep a record of it
       /* gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent goToImageDisplay = new Intent(getBaseContext(), ImageDisplay.class);
                    startActivity(goToImageDisplay);
                } else {
                    Toast.makeText(getApplicationContext(), "Cell Number" + position, Toast.LENGTH_SHORT).show();
                }

            }
        });*/

    }
}
