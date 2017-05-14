package com.example.kip.ad340project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class RecyclerWebActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    String url = "http://dtatum.icoolshow.net/ad340/country.json";

    //2D Array to hold country name and country code
    List<String[]> result = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerViewLayoutManager = new LinearLayoutManager(context);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecyclerWebActivity.CustomAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        String[] color = new String[3];
                        color[0] = response.getJSONObject(i).getString("name");
                        color[1] = response.getJSONObject(i).getString("dial_code");
                        color[2] = response.getJSONObject(i).getString("code");
                        result.add(color);
                    }
                    //refresh of recycler view
                    recyclerViewAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSON", "Error: " + error.getMessage());
            }
        });
        //add to RequestQueue
        queue.add(jsonReq);
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            //country name and code strings
            public TextView mCName;
            public TextView mDialCode;
            public TextView mCCode;

            public ViewHolder(View v) {
                super(v);
                mCName = (TextView) v.findViewById(R.id.name);
                mDialCode= (TextView) v.findViewById(R.id.dial_code);
                mCCode = (TextView) v.findViewById(R.id.code);
            }
        }

        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate view
            View item = getLayoutInflater().inflate(R.layout.recycler_list, parent, false);

            //call ViewHolder Constructor, pass view, and return it
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        // replace contents of a view (Required by layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mCName.setText(result.get(position)[0]);
            holder.mDialCode.setText(result.get(position)[1]);
            holder.mCCode.setText(result.get(position)[2]);
        }

        //Return size of dataset (Required by layout manager)
        @Override
        public int getItemCount() {
            return result.size();
        }
    }
}

