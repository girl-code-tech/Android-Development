package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    FloatingActionButton floatingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView=findViewById(R.id.scrollView);
        floatingBtn=findViewById(R.id.floatUpBtn);
        floatingBtn.setVisibility(View.INVISIBLE);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new
            ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    int height=scrollView.getScrollY();
                    if(height>=2000){
                        //Hide Menu
//Display FloatingButton
                        floatingBtn.setVisibility(View.VISIBLE);
                    }
                    else{
                        floatingBtn.setVisibility(View.INVISIBLE);
                    }
                }
            });
    }
    public void gotoTop(View v){
        scrollView.setScrollY(10);
    }
}

