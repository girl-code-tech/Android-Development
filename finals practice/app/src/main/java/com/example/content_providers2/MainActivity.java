package com.example.content_providers2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> lisdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.simple_listView);
        lisdata = new ArrayList<String>();

        fetchContact();
    }

    private void fetchContact() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }

        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = null;     //provides data column-wise
        String selection = null;        //provides data row-wise
        String[] selectionargs = null;
        String order = null;


        Cursor cursor = contentResolver.query(uri, projection, selection, selectionargs, order);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                String full_Contact = name+"\n"+number;
                lisdata.add(full_Contact);

            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lisdata);
        listView.setAdapter(adapter);

    }
}