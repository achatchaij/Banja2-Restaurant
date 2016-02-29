package com.example.chatchai_j.banjarestaurant;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by chatchai_j on 29/02/2016.
 */
public class MyAlertDialog {

    public void myDialog(Context context, String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.icon_question);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setCancelable(false);   // ถ้า pop ใน unknow กดไม่ได้
        builder.setPositiveButton("โอเค", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }

}   // Main Class
