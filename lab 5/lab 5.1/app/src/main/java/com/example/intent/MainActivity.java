package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= (Button) findViewById(R.id.call_btn);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                        i.putExtra("Value1", "Android By Javatpoint");
                        i.putExtra("Value2", "Simple Tutorial");
// Set the request code to any code you like, you can identify the
// callback via this code
                        startActivity(i);
                    }
                }
        );

    }
}