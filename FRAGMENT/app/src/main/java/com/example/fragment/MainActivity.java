package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }











    public void selectFrag(View view)
    {

        Fragment fr;


        if(view==findViewById(R.id.frag2)){

            fr = new fragment_two();
            Toast t = Toast.makeText(getApplicationContext(),"Button 2 clicked",Toast.LENGTH_SHORT);
            t.setMargin(50,50);
            t.show();
        }

        else{

            fr = new ExampleFragment();
            Toast t = Toast.makeText(getApplicationContext(),"Button 1 clicked"+fr,Toast.LENGTH_LONG);
            t.setMargin(50,50);
            t.show();


        }
        fr = new fragment_two();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_VIEW, fr);
        fragmentTransaction.commit();
        Toast tt = Toast.makeText(getApplicationContext(),"fr updated",Toast.LENGTH_SHORT);
        tt.setMargin(100,150);
       // tt.show();



    }
}