package com.example.photosharingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btn_add_Photo, title_page, subtitle_page;
    Button btn_page_photo, btn_page_chat;
    View dot_menu;
    ImageView ic_states;
    Animation btt, bttwo, imgbounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        imgbounce = AnimationUtils.loadAnimation(this, R.anim.imgbounce);

        //setting underline under textview
        btn_add_Photo = (TextView) findViewById(R.id.btn_add_photo);
        btn_add_Photo.setPaintFlags(btn_add_Photo.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        //getting reference to the ids
        title_page = (TextView) findViewById(R.id.title_page);
        subtitle_page = (TextView) findViewById(R.id.subtitle_page);
        btn_page_photo = (Button) findViewById(R.id.btn_page_photo);
        btn_page_chat = (Button) findViewById(R.id.btn_page_chat);
        dot_menu = (View) findViewById(R.id.dot_menu);
        ic_states = (ImageView) findViewById(R.id.ic_states);

        //Adding Event listener
        btn_add_Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PhotoCateActivity.class);
                startActivity(i);
            }
        });






        btn_page_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic_states.setImageResource(R.drawable.icchat);
                title_page.setText("None Chat");
                subtitle_page.setText("Build a circle that impact society");
                btn_add_Photo.setText("Find a Friend");
                btn_add_Photo.setTextColor(Color.parseColor("#DF5F7D"));

                //setting Animations
                ic_states.startAnimation(imgbounce);
                title_page.startAnimation(btt);
                subtitle_page.startAnimation(btt);
                btn_add_Photo.startAnimation(bttwo);

                //set animation and background resources
                btn_page_photo.setBackgroundResource(R.drawable.iccamun);
                btn_page_chat.setBackgroundResource(R.drawable.icmsgan);
                btn_page_photo.animate().scaleX(0.7f).scaleY(0.7f).setDuration(350).start();
                btn_page_chat.animate().scaleX(1f).scaleY(1f).setDuration(350).start();
                dot_menu.animate().translationX(430).setDuration(350).setStartDelay(100).start();
            }
        });

        btn_page_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic_states.setImageResource(R.drawable.icphotos);
                title_page.setText("No Photos");
                subtitle_page.setText("Add a picture for your circle");
                btn_add_Photo.setText("Add Photo");
                btn_add_Photo.setTextColor(Color.parseColor("#706AC9"));

                //setting Animations
                ic_states.startAnimation(imgbounce);
                title_page.startAnimation(btt);
                subtitle_page.startAnimation(btt);
                btn_add_Photo.startAnimation(bttwo);

                //set animation and background resources
                btn_page_photo.setBackgroundResource(R.drawable.iccaman);
                btn_page_chat.setBackgroundResource(R.drawable.icmsgun);
                btn_page_chat.animate().scaleX(0.7f).scaleY(0.7f).setDuration(350).start();
                btn_page_photo.animate().scaleX(1f).scaleY(1f).setDuration(350).start();
                dot_menu.animate().translationX(0).setDuration(350).setStartDelay(100).start();
            }
        });

    }
}