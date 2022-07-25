package com.example.broadcast_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyReceiver mReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(mReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}