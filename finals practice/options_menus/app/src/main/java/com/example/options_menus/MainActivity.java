package com.example.options_menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<String> contacts = new ArrayList<String>();
    ArrayAdapter adapter;
    int position;
    Button submit;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts.add("Sannjinee");
        contacts.add("Radha");
        contacts.add("Rani");
        contacts.add("Suti");
        adapter = new ArrayAdapter<>(this, R.layout.listview, contacts);
        listview = (ListView) findViewById(R.id.simple_listview);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
        input = (EditText) findViewById(R.id.input);
        submit = (Button) findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacts.add(input.getText().toString());
                listview.setAdapter(adapter);
            }
        });


        listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        menu.setHeaderTitle("Select The Action");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Delete Clicked", Toast.LENGTH_SHORT).show();
                contacts.remove(position);
                listview.setAdapter(adapter);
                listview.setBackgroundColor(Color.GRAY);
                /*
                Intent intent = new Intent(this, ActivityForItemOne.class);
                this.startActivity(intent);
                break;
                 */
                break;

            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Edit Clicked", Toast.LENGTH_SHORT).show();
                listview.setBackgroundColor(Color.GREEN);
                break;
        }

        return super.onContextItemSelected(item);
    }



}