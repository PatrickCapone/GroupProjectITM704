package com.example.food;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Food";
    private static final String TABLE_NAME = "Food_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "VEG";
    public static final String COL_3 = "HEALTHY";
    public static final String COL_4 = "PRICE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, VEG TEXT, HEALTHY TEXT, PRICE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData(){
       SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME,null);
    }

    public boolean updateData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return true;
    }

    public Integer deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{});
    }
}
