package com.example.lab_task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class new_activity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    MainActivity mainActivity;
    SQLHelper db;
    ArrayList<String> details = new ArrayList<String>();
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        listView = (ListView) findViewById(R.id.simple_listView);
        db = new SQLHelper(this);
        adapter = new ArrayAdapter(this, R.layout.listview_item, details);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        Cursor res = db.getdata();
        if(res.getCount()==0){
            Toast.makeText(new_activity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(res.moveToNext()){
                String record = "Name: " +res.getString(0)+"CNIC: "+res.getString(1)+"Mobile Number: "+res.getString(2)+"Email: "+res.getString(3)+"Date of Birth: "+res.getString(4);
                details.add(record);
                listView.setAdapter(adapter);
            }
        }

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.update_delete,menu);
        menu.setHeaderTitle("Select The Action");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.item2:
                //Toast.makeText(getApplicationContext(), "Are you sure, you want to edit record?", Toast.LENGTH_SHORT).show();
                 details.remove(position);
                 listView.setAdapter(adapter);
                break;

            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Please, fill in here your fields to update the record", Toast.LENGTH_LONG).show();
                intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;


        }

        return super.onContextItemSelected(item);
    }

}