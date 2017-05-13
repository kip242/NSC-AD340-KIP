package com.example.kip.ad340project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RecyclerActivity extends AppCompatActivity {
    Context context;

    TextView results;
    String JsonURL = "https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Array.JSON";
    String data = "";
    RequestQueue requestQueue;
    /*RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;*/


    // 2D data array
    /*String[][] subjects =
            {
                    {"DAD", "70"},
                    {"MOM", "68"},
                    {"ME", "39"},
                    {"WIFE", "36"},
                    {"DILLON", "9"},
                    {"FITZ", "3"},
                    {"HANNAH", "2"},
                    {"ELLIOT", "NB"},
                    {"LUCIUS", "6"},
                    {"KIM", "45"},
                    {"ELIZABETH", "37"},
                    {"REBECCA", "36"},
                    {"BRENDAN", "38"},
                    {"ETHAN", "9"},
                    {"MEGHAN", "7"},
                    {"MICHAEL", "15"},
                    {"HANNAH", "2"},
                    {"ELLIOT", "NB"},
                    {"LUCIUS", "6"},
                    {"KIM", "45"},
                    {"ELIZABETH", "37"},
                    {"REBECCA", "36"},
                    {"BRENDAN", "38"},
                    {"ETHAN", "9"},
                    {"MEGHAN", "7"},
                    {"MICHAEL", "15"}
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity);

        requestQueue = Volley.newRequestQueue(this);
        results = (TextView) findViewById(R.id.jsonData);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        context = getApplicationContext();

        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        //linear layout
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);*/

        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,
                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            JSONObject colorObj = response.getJSONObject(0);
                            JSONArray colorArry = colorObj.getJSONArray("colorArray");
                            for (int i = 0; i < colorArry.length(); i++) {

                                JSONObject jsonObject = colorArry.getJSONObject(i);

                                String color = jsonObject.getString("colorName");
                                String hex = jsonObject.getString("hexValue");


                                data += "Color Number " + (i + 1) + "\nColor Name: " + color +
                                        "\nHex Value : " + hex + "\n\n\n";
                            }
                            results.setText(data);
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            //error tracking
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    // Volley errors
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(arrayreq);
    }
}
/* public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTitle;
            public TextView mDetail;
            public ViewHolder(View v) {
                super(v);
                mTitle = (TextView) v.findViewById(R.id.subject_1);
                mDetail = (TextView) v.findViewById(R.id.subject_2);
            }

        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

            // Inflate the view for this view holder
            View item = LayoutInflater.from(context).inflate(R.layout.recycler_list, parent, false);

            // Pass view to ViewHolder and return that new view holder
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTitle.setText(subjects[position][0]);
            holder.mDetail.setText(subjects[position][1]);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return subjects.length;
        }
    }

}*/



