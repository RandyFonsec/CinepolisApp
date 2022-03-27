package com.example.cinepolisapp.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.cinepolisapp.R;

public class LoadingDialog {

    private Activity activity;
    private AlertDialog dialog;

    public LoadingDialog(Activity activity){
        this.activity = activity;
    }

    public void startDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading_box, null));
        builder.setCancelable(false);

        dialog = builder.create();

        dialog.show();
    }

    public void dismissDialog(){
        dialog.dismiss();
    }
}
