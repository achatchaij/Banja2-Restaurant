package com.example.chatchai_j.banjarestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chatchai_j on 29/02/2016.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "banja.db";
    private static final int database_version = 1;
    private static final String create_table_user = "create table userTABLE (" +
            "_id integer primary key, " +
            "User text, " +
            "Password text, " +
            "Name text);";
    private static final String create_table_food = "create table foodTABLE (" +
            "_id integer primary key, " +
            "Food text, " +
            "Price text, " +
            "Source text);";

    private static final String create_table_order ="create table orderTABLE (" +
            "_in integer primary key, " +
            "Officer text," +
            "Desk text, " +
            "Food text, " +
            "Amount text);";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);


    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table_food);
        sqLiteDatabase.execSQL(create_table_user);
        sqLiteDatabase.execSQL(create_table_order);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}   // Main Class
