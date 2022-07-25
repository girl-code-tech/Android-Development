package com.example.lab_task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String Database_Name = "details.db";
    private static final String Table_Name = "biodata";
    public SQLHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+ Table_Name+"(name TEXT primary key, nic TEXT, mobile_number INTEGER, email TEXT, dob TEXT)";
        sqLiteDatabase.execSQL(query);
        Log.d("Tag", "Database Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + Table_Name);
        Log.d("Tag", "Database Upgrading");
        onCreate(sqLiteDatabase);
    }


    public boolean insert(String name, String nic, int mob, String email, String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("nic", nic);
        contentValues.put("mobile_number", mob);
        contentValues.put("email", email);
        contentValues.put("dob", dob);
        long result = db.insert(Table_Name, null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean update(String name, String nic, int mob, String email, String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nic", nic);
        contentValues.put("mobile_number", mob);
        contentValues.put("email", email);
        contentValues.put("dob", dob);
        Cursor cursor = db.rawQuery("Select * from "+Table_Name+" where name = ?", new String[]{name});

        if(cursor.getCount()>0) {
            long result = db.update(Table_Name, contentValues, "ID=?", new String[]{name});
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

    public Boolean deletedata (String name)
    {
        SQLiteDatabase my_db = this.getWritableDatabase();
        Cursor cursor = my_db.rawQuery("Select * from "+Table_Name+" where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = my_db.delete(Table_Name, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase my_db = this.getWritableDatabase();
        Cursor cursor = my_db.rawQuery("Select * from "+Table_Name, null);
        return cursor;

    }





}