package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    TextView textView;
    List lst;

    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            textView.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        textView = (TextView) findViewById(R.id.textView);

        lst = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(lst.size()>0){
            sensorManager.registerListener(sensorEventListener, (Sensor)lst.get(0), SensorManager.SENSOR_DELAY_NORMAL);

        }

        else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }


    }
    @Override
    protected void onStop() {
        if(lst.size()>0){
            sensorManager.unregisterListener(sensorEventListener);
        }
        super.onStop();
    }
}