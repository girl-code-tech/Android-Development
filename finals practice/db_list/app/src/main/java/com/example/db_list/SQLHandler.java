package com.example.db_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLHandler extends SQLiteOpenHelper {
    //Context context;

    private static final String Database_Name = "class.db";
    private static final String Table_Name = "class";
    public SQLHandler(@Nullable Context context) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        //this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+ Table_Name+"(ID TEXT primary key, NAME TEXT, AGE INTEGER)";
        sqLiteDatabase.execSQL(query);
        Log.d("Tag", "Database Created");
        //Toast.makeText(this.context, "Database Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + Table_Name);
        Log.d("Tag", "Database Upgrading");
        onCreate(sqLiteDatabase);
    }


    public boolean insert(String cms, String name, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", cms);
        contentValues.put("NAME", name);
        contentValues.put("AGE", age);
        long result = db.insert(Table_Name, null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean update(String cms, String name, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("AGE", age);
        Cursor cursor = db.rawQuery("Select * from "+Table_Name+" where ID = ?", new String[]{cms});

        if(cursor.getCount()>0) {
            long result = db.update(Table_Name, contentValues, "ID=?", new String[]{cms});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

            else {
                return false;
            }

        }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from "+Table_Name, null);
        return cursor;

    }





}