package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView result;

    public static final String MyPREFERENCES = "MyPrefs" ;
    String getvalue="";
    String check_Gender="";
    EditText User_name;
    EditText Password;
    EditText Age;
    EditText Addres;
    DatePicker dob;
    RadioButton genderr;
    RadioButton gender;
    Spinner spinner;
    String user_name, password, address, DOB, age;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        spinner= (Spinner) findViewById(R.id.state);
        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.state,
                android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);


        Button btn_submit= (Button) findViewById(R.id.submit);
        User_name= (EditText) findViewById(R.id.Name);
        Password= (EditText) findViewById(R.id.Password);
        Age= (EditText) findViewById(R.id.Age);
        Addres= (EditText) findViewById(R.id.Address);
        dob= (DatePicker) findViewById(R.id.DOB);
        genderr= (RadioButton) findViewById(R.id.male);
        gender= (RadioButton) findViewById(R.id.female);
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
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result= (TextView) findViewById(R.id.result);

                user_name=User_name.getText().toString();
                age=Age.getText().toString();
                address= Addres.getText().toString();
                DOB=dob.getDayOfMonth()+"-"+dob.getMonth()+"-"+dob.getYear();

                result.setText("\nUsername: "+user_name+"\nAge: "+age+
                        "\nAddress: "+address+"\nState: "+ getvalue+
                        "\nDOB: "+DOB+
                        "\nGender: "+check_Gender
                        );





            }
        });

    }


    @Override
    protected void onPause() {

        super.onPause();
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Name_Key", user_name);
        editor.putString("Password_key", password);
        editor.putString("Age_Key", age);
        editor.putString("Address_key", address);
        editor.putString("State_key", getvalue);
        editor.putString("Gender_Key", check_Gender);
        editor.putString("Dob_Key", DOB);

        //editor.commit();
        editor.apply();


    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences sh = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        String name= sh.getString("Name_Key", "");
        String age = sh.getString("Age_Key", "");

        String dobb= sh.getString("Dob_Key", "");
        String gen = sh.getString("Gender_Key", "");

        String stat= sh.getString("State_key", "");
        String address = sh.getString("Address_key", "");

        String pass= sh.getString("Password_key", "");

        //Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT).show();


        //int a = sh.getInt("age", 0);
        //Addres= (EditText) findViewById(R.id.Address);
        // Setting the fetched data
        // in the EditTexts
        //name.setText(s1);
        Addres.setText(address);
        User_name.setText(name);
        Password.setText(pass);
        Age.setText(age);






    }
}