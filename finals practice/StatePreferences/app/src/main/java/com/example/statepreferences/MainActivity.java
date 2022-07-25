package com.example.statepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ED_Uname, ED_Password;
    private static final String MyPreferences = "MyPrefs";
    private final String UnameKey = "NameKey", PassKey = "PassKey";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button mButton_Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ED_Password = (EditText) findViewById(R.id.ED_Password);
        ED_Uname = (EditText) findViewById(R.id.ED_Uname);
        mButton_Submit = (Button) findViewById(R.id.btn_Submit);
        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        mButton_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ED_Uname.setText(sharedPreferences.getString(UnameKey, ""));
        ED_Password.setText(sharedPreferences.getString(PassKey, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor.putString(UnameKey, ED_Uname.getText().toString());
        editor.putString(PassKey, ED_Password.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(getApplicationContext(), "SharePreferences Edited", Toast.LENGTH_SHORT).show();
    }
}
/*
    Understanding the state preferences
2. Understanding state of an application, How to
        maintain it, and how to restore it.
        3. Create app based state preferences
        4. Create activity based shared preferences*/