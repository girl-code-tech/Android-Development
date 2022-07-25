package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_activity1, btn_activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_activity1 = (Button) findViewById(R.id.btn_activity1);
        btn_activity2 = (Button) findViewById(R.id.btn_activity2);
        btn_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNewActivity();
            }
        });
    }

    public void getNewActivity(){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("sanjinee", "sdsf");
        startActivity(i);
    }
}