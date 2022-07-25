package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_Add;
    EditText num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        btn_Add = (Button) findViewById(R.id.btn_add);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());

            }
        });
    }



    public class multitask extends AsyncTask<String, String, String> implements com.example.thread.multitask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

       
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }


}