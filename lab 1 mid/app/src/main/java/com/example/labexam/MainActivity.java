package com.example.labexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText fname= (EditText) findViewById(R.id.fname);
        EditText lname= (EditText) findViewById(R.id.lname);
        EditText email = (EditText) findViewById(R.id.email);
        RadioButton male= (RadioButton) findViewById(R.id.male);
        RadioButton female = (RadioButton) findViewById(R.id.female);
        RadioButton other = (RadioButton) findViewById(R.id.other);
        DatePicker dob= (DatePicker) findViewById(R.id.DOB);
        Button submit = (Button) findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check_Gender="";
                if(male.isChecked())
                {
                   check_Gender="Male";

                }

                else if(female.isChecked()){
                    check_Gender="Female";
                }

                else{
                    check_Gender="Other";
                }

                String result="\nUsername: "+fname.getText().toString()+" "+lname.getText().toString()+
                        "\nEmail: "+ email.getText().toString()+
                        "\nDOB: "+dob.getDayOfMonth()+"-"+dob.getMonth()+"-"+dob.getYear()+
                        "\nGender: "+check_Gender;

                Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), second.class);
                i.putExtra("Value1", result);

                startActivity(i);


            }
        });








    }
}