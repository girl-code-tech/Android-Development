package com.example.text_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText ED_text;
    Button btn_Speak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ED_text = (EditText) findViewById(R.id.ED_Speak);
        btn_Speak = (Button) findViewById(R.id.BTN_Speak);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                    textToSpeech.setPitch((float) 0.3);


                }
            }
        });



        btn_Speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getSpeakText = ED_text.getText().toString();
                textToSpeech.speak(getSpeakText, TextToSpeech.QUEUE_FLUSH, null);
                if(textToSpeech.isSpeaking())
                {
                    Toast.makeText(getApplicationContext(), "Engine Speaking", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }

    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}