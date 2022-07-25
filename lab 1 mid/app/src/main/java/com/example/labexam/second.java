package com.example.labexam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        TextView text= (TextView) findViewById(R.id.text_Show);
        text.setText(value1);





    }
}
