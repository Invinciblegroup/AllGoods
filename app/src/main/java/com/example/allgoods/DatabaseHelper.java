package com.example.allgoods;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context,"mylist.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL("CREATE TABLE thoughts (ID INTEGER PRIMARY KEY AUTOINCREMENT,COMMENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table
        db.execSQL("DROP TABLE IF EXISTS thoughts");
        onCreate(db);
    }

    public boolean addData(String item1){
        //Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        //create content values
        ContentValues contentValues = new ContentValues();
        contentValues.put("COMMENT", item1);
        //add values into database
        long result = db.insert("thoughts", null,contentValues);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        //create cursor to select all values
        Cursor data = db.rawQuery("SELECT * FROM thoughts ", null);
        return data;
    }
}
