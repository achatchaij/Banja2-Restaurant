package com.example.chatchai_j.banjarestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by chatchai_j on 29/02/2016.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readlSqLiteDatabase;


    public MyManage(Context context) {

        //Create Database
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readlSqLiteDatabase = myOpenHelper.getReadableDatabase();
    }   // Constructor

}   //Main Class
