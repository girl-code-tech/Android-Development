package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title1,subtitle1, title2, subtitle2, title_Itemx1, subtitle_Itemx1, title_Itemx2, subtitle_Itemx2,title_Itemx3, subtitle_Itemx3;
    Button btn_cls, btn_plus;
    LinearLayout itemX1, itemX2, itemX3;
    ImageView icTask;
    Animation bts, stb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title1 = (TextView) findViewById(R.id.title1);
        subtitle1 = (TextView) findViewById(R.id.subtitle1);
        title2 = (TextView) findViewById(R.id.title2);
        subtitle2 = (TextView) findViewById(R.id.subtitle2);
        title_Itemx1 = (TextView) findViewById(R.id.title_itemX1);
        subtitle_Itemx1 = (TextView) findViewById(R.id.subtitle_itemX1);
        title_Itemx2 = (TextView) findViewById(R.id.title_itemX2);
        subtitle_Itemx2 = (TextView) findViewById(R.id.subtitle_itemX2);
        title_Itemx3 = (TextView) findViewById(R.id.title_itemX3);
        subtitle_Itemx3 = (TextView) findViewById(R.id.subtitle_itemX3);
        itemX1 = (LinearLayout) findViewById(R.id.itemX1);
        itemX2 = (LinearLayout) findViewById(R.id.itemX2);
        itemX3 = (LinearLayout) findViewById(R.id.itemX3);
        icTask = (ImageView) findViewById(R.id.ictask);
        bts = AnimationUtils.loadAnimation(this, R.anim.bts);
        stb = AnimationUtils.loadAnimation(this, R.anim.stb);
        icTask.startAnimation(stb);



        btn_cls = (Button) findViewById(R.id.btncls);
        btn_plus = (Button) findViewById(R.id.btnplus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_cls.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(1000).start();
                btn_plus.animate().alpha(0).translationY(400).setDuration(600).start();
                title2.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(1000).start();
                subtitle2.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(1000).start();
                //icTask.animate().alpha(0).translationY(400).setDuration(600).start();
                title1.animate().alpha(0).translationY(400).setDuration(600).start();
                subtitle1.animate().alpha(0).translationY(400).setDuration(600).start();
                itemX1.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(300).start();
                itemX2.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(300).start();
                itemX3.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(300).start();
                icTask.startAnimation(bts);
                icTask.setVisibility(View.GONE);

            }
        });
        btn_cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icTask.setVisibility(View.VISIBLE);
                icTask.startAnimation(bts);

                title2.animate().alpha(0).translationY(400).setDuration(200).start();
                subtitle2.animate().alpha(0).translationY(400).setDuration(200).start();

                btn_plus.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(1000).start();
                btn_cls.animate().alpha(0).translationY(400).setDuration(200).start();

                title1.animate().alpha(1).translationY(0).setDuration(600).start();
                subtitle1.animate().alpha(1).translationY(0).setDuration(600).start();

                itemX1.animate().alpha(0).translationY(400).setDuration(200).start();
                itemX2.animate().alpha(0).translationY(400).setDuration(200).start();
                itemX3.animate().alpha(0).translationY(400).setDuration(200).start();
            }
        });

        //setting alpha
        btn_cls.setAlpha(0);
        btn_cls.setTranslationY(400);
        title2.setAlpha(0);
        title2.setTranslationY(100);
        subtitle2.setAlpha(0);
        subtitle2.setTranslationY(100);
        itemX2.setAlpha(0);
        itemX2.setTranslationY(400);
        itemX1.setAlpha(0);
        itemX1.setTranslationY(400);
        itemX3.setAlpha(0);
        itemX3.setTranslationY(400);


        //customizing the fonts
        Typeface mlight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
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