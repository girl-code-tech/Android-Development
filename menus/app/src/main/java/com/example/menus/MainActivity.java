package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Toast t1 = Toast.makeText(getApplicationContext(), "Settings Clicked", Toast.LENGTH_SHORT);
                t1.show();
                return true;
            case R.id.favorite:
                Toast t2 = Toast.makeText(getApplicationContext(), "Favorites Clicked", Toast.LENGTH_SHORT);
                t2.show();
                return true;
            case R.id.about_us:
                Toast t3 = Toast.makeText(getApplicationContext(), "About Us Clicked", Toast.LENGTH_SHORT);
                t3.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menus, menu);
        //menu.setHeaderTitle("Select The Action");
        return true;
    }
    }
