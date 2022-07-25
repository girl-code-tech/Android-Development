package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_setAlarm, btn_setTimer, btn_StartCamera, btn_SelectContact, btn_ViewContact, btn_InsertContact, btn_SendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_setAlarm = (Button) findViewById(R.id.btn_setAlarm);
        btn_ViewContact = (Button) findViewById(R.id.btn_ViewContact);
        btn_setTimer = (Button) findViewById(R.id.btn_setTimer);
        btn_SelectContact = (Button) findViewById(R.id.btn_SelectContact);
        btn_StartCamera = (Button) findViewById(R.id.btn_StartCamera);
        btn_InsertContact = (Button) findViewById(R.id.btn_InsertContact);
        btn_SendEmail = (Button) findViewById(R.id.btn_SendEmail);

        btn_setTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_timer();
            }
        });

        btn_setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm();
            }
        });

        btn_StartCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCamera();
            }
        });

        btn_SelectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectContact();
            }
        });

        btn_ViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectContact();
            }
        });

        btn_InsertContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertContact("Sareeta", "saree.dg.dfg.com");
            }
        });

        btn_SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("file://" + R.raw.bts);
                //Uri uri = Uri.parse(String.valueOf(R.raw.bts));
                composeEmail("sanjinee.bcskkf18@iba-suk.edu.pk", "Testing App",uri);
            }
        });
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final Uri locationForPhotos;

    private void startCamera() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            //startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

         intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

    }

    static final int REQUEST_SELECT_CONTACT = 1;

    private void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                // Do something with the phone number
                viewContact(contactUri);
            }
           }
    }

    private void set_timer() {
        String message = "Hi";
        int seconds = 30;   //sets timer for 30seconds
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }


    private void set_alarm() {
        String message = "Putr Kam Kar";
        int hour = 5;
        int minutes = 30;
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private void viewContact(Uri contactUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void insertContact(String name, String email) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Toast.makeText(getApplicationContext(), "Contact Inserted", Toast.LENGTH_SHORT).show();
    }
    public void composeEmail(String addresses, String subject, Uri attachment) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        intent.putExtra(Intent.EXTRA_CC, "sanjnee.gehani32@gmail.com");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, There!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Email Sent", Toast.LENGTH_SHORT).show();
        }

    }
}