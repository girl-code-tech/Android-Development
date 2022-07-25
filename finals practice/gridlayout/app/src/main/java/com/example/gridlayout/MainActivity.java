package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button table, relative, frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (Button) findViewById(R.id.table);
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, tableLayout.class);
                startActivity(i);
            }
        });

        relative = (Button) findViewById(R.id.relative);
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, relativeLayout.class);
                startActivity(i);
            }
        });

        frame = (Button) findViewById(R.id.frame);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, frameLayout.class);
                startActivity(i);
            }
        });
    }
}