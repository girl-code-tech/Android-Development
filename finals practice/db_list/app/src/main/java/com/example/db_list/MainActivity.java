package com.example.db_list;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button insert, update, delete, view;
    EditText name, cms, age;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> students = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLHandler db = new SQLHandler(this);
        name = (EditText) findViewById(R.id.name);
        cms = (EditText) findViewById(R.id.cms);
        age = (EditText) findViewById(R.id.age);
        insert = (Button) findViewById(R.id.btnInsert);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btnDelete);
        view = (Button) findViewById(R.id.btnView);
        listView = (ListView) findViewById(R.id.simple_listView);


        adapter = new ArrayAdapter(this, R.layout.listview, students);
        listView.setAdapter(adapter);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = db.insert(cms.getText().toString(), name.getText().toString(), Integer.valueOf(age.getText().toString()));
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = db.update(cms.getText().toString(), name.getText().toString(), Integer.valueOf(age.getText().toString()));
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Update", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                else{
                    while(res.moveToNext()){
                        String record = res.getString(0)+" "+res.getString(1)+" "+res.getString(2);
                        students.add(record);


                    }

                }

            }
        });


    }
}