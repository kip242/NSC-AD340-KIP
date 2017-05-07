package com.example.kip.ad340project;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.util.Log;


public class PickColorDialogFragment extends DialogFragment {
    private static final String TAG = PickColorDialogFragment.class.getSimpleName();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //title of Dialog
        builder.setTitle(R.string.pick_color_title)
                //access to array of colors for items in Dialog
                .setItems(R.array.color_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "Color Selected");
                    }
                });
        return builder.create();
    }
}
