package com.example.broadcast_custom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String toastMessage = "Unknown Action";

        if(intentAction != null){
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power Connected";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power Disconnected";
                    break;
            }
            Toast.makeText(context.getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}