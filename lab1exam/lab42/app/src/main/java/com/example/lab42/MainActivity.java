package com.example.lab42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    private static final int pic_id = 13;
    //String[] notes= new String[100];
    //ArrayList<String> notes = new ArrayList<String>();
    //ArrayList<String> notes= new ArrayList<String>("Daraz Online Shopping", "Spotify Listen to Music", "Snapchat");
    String note[]= new String[] {
            "Daraz Online Shopping                                      Shopping                                            Installed",
            "Spotify Listen to Music                                      Music & Aduio                                      4.4   31MB",
            "Snapchat                                                                          Music & Aduio                                      4.4   31MB",
            "WhatsApp Messenger                                      Shopping                                               Installed",
            "PTV Sports- Live Cricket                                      Music & Aduio                                     4.4   31MB",
            "WhatsApp Business                                      Shopping                                                Installed",
            "Super VPN Client                                              Music & Aduio                                      4.4   31MB",
            "Facebook                                                         Shopping                                      Installed"};



    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new ArrayAdapter<String>(this,
                R.layout.activity_layout, note);
        list= (ListView) findViewById(R.id.simpleListView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position==1||position==2)
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
                else if(position==3||position==4)
                {
                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(camera_intent.resolveActivity(getPackageManager())!=null)
                    {
                        startActivityForResult(camera_intent, pic_id);

                    }


                }

                else{

                }
                Toast.makeText(getApplicationContext(),"Message Semding", Toast.LENGTH_SHORT).show();


            }
        });





    }
}