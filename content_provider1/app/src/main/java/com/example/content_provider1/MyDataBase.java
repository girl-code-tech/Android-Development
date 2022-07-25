package com.example.content_provider1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper {
    private static final String table_name = "Image_table";
    public MyDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version)
    {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
    public void onCreate(SQLiteDatabase db)
    {
        // TODO Auto-generated method stub
        db.execSQL("create table "+table_name+"(name text,age int,image blob);");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto-generated method stub

    }
}
