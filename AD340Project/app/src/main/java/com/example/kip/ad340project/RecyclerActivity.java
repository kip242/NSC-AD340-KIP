package com.example.kip.ad340project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Kip on 4/27/2017.
 */

public class RecyclerActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    // 2D data array
    String[][] subjects=
            {
                    { "ANDROID", "1" },
                    { "PHP", "2" },
                    { "JSON", "3" },
                    { "SWIFT", "4" },
                    { "OBJECTIVE-C", "5" },
                    { "SQL", "" },
                    { "JAVA", "" },
                    { "JAVASCRIPT", "" },
                    { "REACT", "" },
                    { "PYTHON", "" },
                    { "ANGULAR", "" },
                    { "JQUERY", "" },
                    { "CANVAS", "" },
                    { "D3", "" },
                    { "MATPLOTLIB", "" },
                    { "NODE", "" }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        //linear layout
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

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
}

