package com.masum.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.masum.todos.TodosOverviewActivity;

public class TodoTable {

    // Database table
    public static final String TABLE_TODO = "todo";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_SUMMARY = "summary";
    public static final String COLUMN_DESCRIPTION = "description";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "CREATE TABLE " +
            TABLE_TODO
            + "( "
            + COLUMN_ID + " INTEGER PRIMARY  KEY AUTOINCREMENT, "
            + COLUMN_CATEGORY  +" VARCHAR(255) NOT NULL, "
            + COLUMN_SUMMARY + " VARCHAR(255) NOT NULL, "
            + COLUMN_DESCRIPTION + " VARCHAR(255) NOT NULL "
            +");";
    // Database drop table SQL statement
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_TODO;


    public static void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(DATABASE_CREATE);
            Log.i(TodosOverviewActivity.TAG, "table created successfully");
        }catch (Exception e) {
            //System.out.println("ex: "+e.getMessage());
            Log.i(TodosOverviewActivity.TAG, "exception: "+e.getMessage());
        }

    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(TodoTable.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(database);
    }
}
