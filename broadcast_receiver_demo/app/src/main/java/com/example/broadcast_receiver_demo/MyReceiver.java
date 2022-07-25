package com.example.broadcast_receiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override


    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String actionString = intent.getAction();
        Toast.makeText(context.getApplicationContext(), actionString, Toast.LENGTH_SHORT).show();
       // String timeZone = intent.getStringExtra("time-zone");
       // Log.d(TAG, "onReceive"+timeZone);


        boolean isAirplanModeOn = intent.getBooleanExtra("state", false);
        Log.d(TAG, "onReceive ->00000 Airplane mode is On: "+isAirplanModeOn);
       // Toast.makeText(context.getApplicationContext(), "Airplane mode is On: "+isAirplanModeOn, Toast.LENGTH_SHORT).show();
        PendingResult pendingResult = goAsync();
        Log.d(TAG, "Boot Action Received");
        new Task(pendingResult, intent).execute();



    }

    private static class Task extends AsyncTask<Void, Void, Void>{

        PendingResult pendingResult;
        Intent intent;

        public Task(PendingResult pendingResult, Intent intent) {
            this.pendingResult = pendingResult;
            this.intent = intent;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Log.d(TAG, "doInBackground: Work Started ");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Log.d(TAG, "OnPostExecute: Work Finished");
            pendingResult.finish();
        }
    }

}