package com.example.kip.ad340project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


public class VolleyApplication extends AppCompatActivity {
    private static VolleyApplication sInstance;
    final TextView mTextView = (TextView) findViewById(R.id.text);
    RequestQueue queue = new Volley.newRequestQueue(this);
    String url="http://www.google.com";

    String stringRequest = StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    mTextView.setText("Response is: "+response.substring(0,500));
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    mTextView.setText("That didn't work");
                }
            });


    queue.add(stringRequest);
}
