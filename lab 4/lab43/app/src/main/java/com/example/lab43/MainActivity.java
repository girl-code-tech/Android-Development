package com.example.lab43;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox arm = (CheckBox) findViewById(R.id.arm);
        CheckBox ear = (CheckBox) findViewById(R.id.ears);
        CheckBox eyes = (CheckBox) findViewById(R.id.eyes);
        CheckBox nose = (CheckBox) findViewById(R.id.nose);
        CheckBox shoes = (CheckBox) findViewById(R.id.shoes);
        CheckBox moustache = (CheckBox) findViewById(R.id.moustache);
        CheckBox hat = (CheckBox) findViewById(R.id.hat);
        CheckBox glasses = (CheckBox) findViewById(R.id.glasses);
        CheckBox mouth = (CheckBox) findViewById(R.id.mouth);
        CheckBox eyebrowse = (CheckBox) findViewById(R.id.eyebrowse);
        ImageView arm_img = (ImageView) findViewById(R.id.arms_img);
        ImageView ear_img = (ImageView) findViewById(R.id.ears_img);
        ImageView eyes_img = (ImageView) findViewById(R.id.eyes_img);
        ImageView nose_img = (ImageView) findViewById(R.id.nose_img);
        ImageView shoes_img = (ImageView) findViewById(R.id.shoes_img);
        ImageView moustache_img = (ImageView) findViewById(R.id.moustache_img);
        ImageView hat_img = (ImageView) findViewById(R.id.hat_img);
        ImageView glasses_img = (ImageView) findViewById(R.id.glasses_img);
        ImageView mouth_img = (ImageView) findViewById(R.id.mouth_img);
        ImageView eyebrowse_img = (ImageView) findViewById(R.id.eyebrowse_img);
        eyes_img.setVisibility(View.INVISIBLE);
        arm_img.setVisibility(View.INVISIBLE);
        ear_img.setVisibility(View.INVISIBLE);
        nose_img.setVisibility(View.INVISIBLE);
        shoes_img.setVisibility(View.INVISIBLE);
        moustache_img.setVisibility(View.INVISIBLE);
        hat_img.setVisibility(View.INVISIBLE);
        glasses_img.setVisibility(View.INVISIBLE);
        mouth_img.setVisibility(View.INVISIBLE);
        eyebrowse_img.setVisibility(View.INVISIBLE);

        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arm_img.getVisibility()== View.VISIBLE)
                {
                    arm_img.setVisibility(View.INVISIBLE);
                }

                else{
                    arm_img.setVisibility(View.VISIBLE);
                }

            }
        });
        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ear_img.getVisibility()== View.VISIBLE)
                {
                    ear_img.setVisibility(View.INVISIBLE);
                }

                else{
                    ear_img.setVisibility(View.VISIBLE);
                }
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(glasses_img.getVisibility()== View.VISIBLE)
                {
                    glasses_img.setVisibility(View.INVISIBLE);
                }

                else{
                    glasses_img.setVisibility(View.VISIBLE);
                }
            }
        });
        nose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nose_img.getVisibility()== View.VISIBLE)
                {
                    nose_img.setVisibility(View.INVISIBLE);
                }

                else{
                    nose_img.setVisibility(View.VISIBLE);
                }
            }
        });


        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hat_img.getVisibility()== View.VISIBLE)
                {
                    hat_img.setVisibility(View.INVISIBLE);
                }

                else{
                    hat_img.setVisibility(View.VISIBLE);
                }
            }
        });


        moustache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moustache_img.getVisibility()== View.VISIBLE)
                {
                    moustache_img.setVisibility(View.INVISIBLE);
                }

                else{
                    moustache_img.setVisibility(View.VISIBLE);
                }
            }
        });

        mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mouth_img.getVisibility()== View.VISIBLE)
                {
                    mouth_img.setVisibility(View.INVISIBLE);
                }

                else{
                    mouth_img.setVisibility(View.VISIBLE);
                }
            }
        });
/*
        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hat_img.getVisibility()== View.VISIBLE)
                {
                    arm_img.setVisibility(View.INVISIBLE);
                }

                else{
                    arm_img.setVisibility(View.VISIBLE);
                }
            }
        });
        */

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shoes_img.getVisibility()== View.VISIBLE)
                {
                    shoes_img.setVisibility(View.INVISIBLE);
                }

                else{
                    shoes_img.setVisibility(View.VISIBLE);
                }
            }
        });
        eyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eyes_img.getVisibility()== View.VISIBLE)
                {
                    eyes_img.setVisibility(View.INVISIBLE);
                }

                else{
                    eyes_img.setVisibility(View.VISIBLE);
                }
            }
        });
        eyebrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eyebrowse_img.getVisibility()== View.VISIBLE)
                {
                    eyebrowse_img.setVisibility(View.INVISIBLE);
                }

                else{
                    eyebrowse_img.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}