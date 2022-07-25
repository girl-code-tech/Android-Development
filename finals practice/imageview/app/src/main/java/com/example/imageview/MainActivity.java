package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1, checkBox2;
    Switch aSwitch;
    RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = (CheckBox) findViewById(R.id.item1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox)view).isChecked();
                if (checked){
                    Toast.makeText(getApplicationContext(), "item 1 clicked", Toast.LENGTH_SHORT).show();
                    //checkBox1.toggle();
                }
                else{
                    Toast.makeText(getApplicationContext(), "item 1 Not clicked", Toast.LENGTH_SHORT).show();
                    //checkBox1.toggle();
                }
            }
        });

        checkBox2 = (CheckBox) findViewById(R.id.item2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox)view).isChecked();
                if (checked){
                    Toast.makeText(getApplicationContext(), "item 2 clicked", Toast.LENGTH_SHORT).show();
                    //checkBox2.toggle();
                }
                else{
                    Toast.makeText(getApplicationContext(), "item 2 Not clicked", Toast.LENGTH_SHORT).show();
                    //checkBox2.toggle();
                }
            }
        });

        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(), "Switch Checked", Toast.LENGTH_SHORT).show();
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Switch Unchecked", Toast.LENGTH_SHORT).show();
                    checkBox2.toggle();
                    checkBox1.toggle();
                }

            }
        });
        gender = (RadioGroup) findViewById(R.id.gender);
        gender.setOnCheckedChangeListener(new
              RadioGroup.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(RadioGroup radioGroup, int i) {
                      if(i == R.id.male){
                          Toast.makeText(getApplicationContext(), "Hey Male", Toast.LENGTH_SHORT).show();
                      }

                      else if(i == R.id.female){
                          Toast.makeText(getApplicationContext(), "Hey Female", Toast.LENGTH_SHORT).show();
                      }
                      else{
                          Toast.makeText(getApplicationContext(), "None Clicked", Toast.LENGTH_SHORT).show();
                      }

                  }
              });




    }

}