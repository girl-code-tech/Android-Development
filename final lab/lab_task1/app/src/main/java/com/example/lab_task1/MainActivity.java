package com.example.lab_task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name, nic, mobile_number, email, dob;
    Button insert, update, delete;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> details = new ArrayList<String>();
    SQLHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        nic = (EditText) findViewById(R.id.nic);
        mobile_number = (EditText) findViewById(R.id.mobile_number);
        email = (EditText) findViewById(R.id.email);
        dob = (EditText) findViewById(R.id.dob);
        insert = (Button) findViewById(R.id.btnInsert);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btndelete);
        listView = (ListView) findViewById(R.id.simple_listView);
        adapter = new ArrayAdapter(this, R.layout.listview_item, details);
        listView.setAdapter(adapter);
        db = new SQLHelper(this);

        registerForContextMenu(listView);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = db.insert(name.getText().toString(), nic.getText().toString(), Integer.valueOf(mobile_number.getText().toString()), email.getText().toString(), dob.getText().toString());
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                }

                Cursor res = db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    while(res.moveToNext()){
                        String record = "Name: " +res.getString(0)+"CNIC: "+res.getString(1)+"Mobile Number: "+res.getString(2)+"Email: "+res.getString(3)+"Date of Birth: "+res.getString(4);
                        details.add(record);
                        listView.setAdapter(adapter);
                    }
                }


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = db.update(name.getText().toString(), nic.getText().toString(), Integer.valueOf(mobile_number.getText().toString()), email.getText().toString(), dob.getText().toString());
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Update", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = db.deletedata(name.getText().toString());
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });





        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(MainActivity.this, new_activity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(), "Not Clciked", Toast.LENGTH_SHORT).show();
            }
        });




    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Select The Action");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Are you sure, you want to edit record?", Toast.LENGTH_SHORT).show();
               // contacts.remove(position);
              //  listview.setAdapter(adapter);
               // listview.setBackgroundColor(Color.GRAY);

                intent = new Intent(this, new_activity.class);
                this.startActivity(intent);
                break;


        }

        return super.onContextItemSelected(item);
    }

}

