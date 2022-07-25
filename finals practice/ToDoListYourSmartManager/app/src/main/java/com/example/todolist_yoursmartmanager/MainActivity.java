package com.example.todolist_yoursmartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title2, subtitle2, title_Itemx1, subtitle_Itemx1, title_Itemx2, subtitle_Itemx2,title_Itemx3, subtitle_Itemx3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title2 = (TextView) findViewById(R.id.title2);
        subtitle2 = (TextView) findViewById(R.id.subtitle2);
        title_Itemx1 = (TextView) findViewById(R.id.title_itemX1);
        subtitle_Itemx1 = (TextView) findViewById(R.id.subtitle_itemX1);
        title_Itemx2 = (TextView) findViewById(R.id.title_itemX2);
        subtitle_Itemx2 = (TextView) findViewById(R.id.subtitle_itemX2);
        title_Itemx3 = (TextView) findViewById(R.id.title_itemX3);
        subtitle_Itemx3 = (TextView) findViewById(R.id.subtitle_itemX3);

        //customizing the fonts
        Typeface mlight = Typeface.createFromAsset(getAssets(), "fonts/Mlight.ttf");
        Typeface mreg = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        title2.setTypeface(mreg);
        subtitle2.setTypeface(mlight);
        title_Itemx1.setTypeface(mreg);
        subtitle_Itemx1.setTypeface(mlight);
        title_Itemx2.setTypeface(mreg);
        subtitle_Itemx2.setTypeface(mlight);
        title_Itemx3.setTypeface(mreg);
        subtitle_Itemx3.setTypeface(mlight);


    }
}