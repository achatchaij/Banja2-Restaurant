package com.example.chatchai_j.banjarestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by chatchai_j on 29/02/2016.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readlSqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_user = "User";
    public static final String conlumn_pass = "Password";
    public static final String column_name = "Name";
    
    public static final String food_table = "foodTABLE";
    public static final String column_food = "Food";
    public static final String column_Price = "Price";
    public static final String colunm_source = "Source";



    public MyManage(Context context) {

        //Create Database
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readlSqLiteDatabase = myOpenHelper.getReadableDatabase();
    }   // Constructor


    public long addFood(String strFood,
                       String strPrice,
                       String strSource) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_food, strFood);
        contentValues.put(column_Price, strPrice);
        contentValues.put(colunm_source, strSource);

        return writeSqLiteDatabase.insert(food_table,null, contentValues);
    }
    //add Value to userTABLE
    public long addUser(String strUser,
                        String strPassword,
                        String strName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_user,strUser);
        contentValues.put(conlumn_pass, strPassword);
        contentValues.put(column_name, strName);


        return writeSqLiteDatabase.insert(user_table, null, contentValues);
    }


}   //Main Class
