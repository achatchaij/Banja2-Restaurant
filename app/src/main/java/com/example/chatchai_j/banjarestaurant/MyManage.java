package com.example.chatchai_j.banjarestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String column_pass = "Password";
    public static final String column_name = "Name";
    
    public static final String food_table = "foodTABLE";
    public static final String column_food = "Food";
    public static final String column_Price = "Price";
    public static final String column_source = "Source";

    public static final String order_table = "orderTABLE";
    public static final String column_officer = "Officer";
    public static final String column_desk = "Desk";
    public static final String column_amount = "Amount";



    public MyManage(Context context) {

        //Create Database
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readlSqLiteDatabase = myOpenHelper.getReadableDatabase();
    }   // Constructor

    public long addOrder(String strOfficer,
                         String strDesk,
                         String strFood,
                         String strAmount) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_officer, strOfficer);
        contentValues.put(column_food, strFood);
        contentValues.put(column_desk, strDesk);
        contentValues.put(column_amount, strAmount);

        return writeSqLiteDatabase.insert(order_table,null,contentValues);
    }
    public String[] searchUser(String strUser) {

        try {
            String[] resultStrings = null;
            Cursor cursor = readlSqLiteDatabase.query(user_table,
                    new String[]{column_id, column_user, column_pass, column_name },
                    column_user +"=?",
            new String[] {String.valueOf(strUser)},
            null,null,null,null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    resultStrings = new String[4];    //จองหน่วยความจำ 4 ค่า
                    for (int i = 0; i < 4; i++) {
                        resultStrings[i] = cursor.getString(i);

                    }// for
                }
            }// if
            cursor.close();
            return resultStrings;

        }catch (Exception e){
            return null;
        }

        //return  new String[0];
    }

    public long addFood(String strFood,
                       String strPrice,
                       String strSource) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_food, strFood);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_source, strSource);

        return writeSqLiteDatabase.insert(food_table,null, contentValues);
    }
    //add Value to userTABLE
    public long addUser(String strUser,
                        String strPassword,
                        String strName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_user,strUser);
        contentValues.put(column_pass, strPassword);
        contentValues.put(column_name, strName);


        return writeSqLiteDatabase.insert(user_table, null, contentValues);
    }


}   //Main Class
