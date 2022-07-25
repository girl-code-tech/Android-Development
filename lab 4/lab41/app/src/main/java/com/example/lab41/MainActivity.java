package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String getvalue="";
    String check_Gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner= (Spinner) findViewById(R.id.state);
        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.state,
                android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);


        Button btn_submit= (Button) findViewById(R.id.submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText User_name= (EditText) findViewById(R.id.Name);
                EditText Password= (EditText) findViewById(R.id.Password);
                EditText Age= (EditText) findViewById(R.id.Age);
                EditText Address= (EditText) findViewById(R.id.Address);
                DatePicker dob= (DatePicker) findViewById(R.id.DOB);
                RadioButton genderr= (RadioButton) findViewById(R.id.male);
                RadioButton gender= (RadioButton) findViewById(R.id.female);
                if (gender.isChecked()) {
                    check_Gender="Female";
                }
                else{
                    check_Gender="Male";
                }


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                          getvalue = String.valueOf(parent.getItemAtPosition(position));
                         //state[0] = (String) parent.getItemAtPosition(position);


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                TextView result= (TextView) findViewById(R.id.result);

                result.setText("\nUsername: "+User_name.getText().toString()+"\nAge: "+Age.getText().toString()+
                        "\nAddress: "+Address.getText().toString()+"\nState: "+ getvalue+
                        "\nDOB: "+dob.getDayOfMonth()+"-"+dob.getMonth()+"-"+dob.getYear()+
                        "\nGender: "+check_Gender
                        );





            }
        });

    }
}