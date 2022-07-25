package com.example.lab42;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    //String[] notes= new String[100];
    ArrayList<String> notes = new ArrayList<String>();
    Button mButton;
    int index=0;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new ArrayAdapter<String>(this,
                R.layout.activity_layout, notes);
        list= (ListView) findViewById(R.id.simpleListView);
        mButton= (Button) findViewById(R.id.btn_submit);
        EditText new_note= (EditText) findViewById(R.id.Note);
        //list.setAdapter(adapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String text=new_note.getText().toString();
                notes.add(text);
                        //Toast toast = Toast.makeText(getApplicationContext(), notes[index], Toast.LENGTH_SHORT);
                //toast.show();
                list.setAdapter(adapter);
                //index+=1;
            }
        });

    }
}