package com.example.lab52;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int pic_id = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button open_camera= (Button) findViewById(R.id.Open_Camera);
        Button send_sms= (Button) findViewById(R.id.Send_SMS);
        Button attach_file= (Button) findViewById(R.id.Attach_File);
        Button call_me = (Button) findViewById(R.id.call_me);
        Button send_mms = (Button) findViewById(R.id.send_mms);
        Button set_timer = (Button) findViewById(R.id.set_timer);
        Button see_map = (Button) findViewById(R.id.see_map);
        
        see_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMap();
            }
        });



        set_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer("HeySanjinee", 8);
            }
        });


        call_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_me();
            }
        });


        open_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Open_Camera();

            }
        });


        send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            send_msg();
            }
        });

        attach_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attach_file();
            }
        });

        send_mms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_mms();
            }
        });


    }




    public void send_mms() {
        String phoneNumber="03112121090";
        Intent intent = new Intent(Intent.ACTION_SEND);
        Toast t= Toast.makeText(getApplicationContext(), "MMS Button Clicked", Toast.LENGTH_SHORT);

        intent.setData(Uri.parse("smsto:"+phoneNumber));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", "Hi sanjineee, Plz listen this song");
        intent.putExtra(Intent.EXTRA_STREAM,  R.raw.sun);
        if (intent.resolveActivity(getPackageManager()) != null) {
            t.show();
            startActivity(intent);
        }
    }



    private void attach_file()
    {

        Intent camera_intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        if(camera_intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(camera_intent);

        }
    }

    public void showMap() {
        Uri geoLocation = null;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private void Open_Camera()
    {

        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, pic_id);

    }
    }

    private void send_msg()
    {
        String msg="Sanjinee";
        Intent sendIntent= new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
        sendIntent.setType("text/plain");
        if(sendIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(sendIntent);

        }


    }




    public void call_me() {
        String phoneNumber="03112121090";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}