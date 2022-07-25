package com.example.photosharingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class chooseUserName_Activity extends AppCompatActivity {

    String User_Name_Story = "usernamestory", User_Name_Story_Local = "", User_Name_Story_New = "";
    Button btn_SaveUserName;
    EditText userNameStory;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_name);
        loadDataUserNameLocal();
        check_Username_local();
        btn_SaveUserName = (Button) findViewById(R.id.btnsaveUsername);
        userNameStory = (EditText) findViewById(R.id.userNameStory);

        btn_SaveUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
                reference = FirebaseDatabase.getInstance().getReference().child("Users").child(userNameStory.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        reference.getRef().child("username").setValue(userNameStory.getText().toString());

                        //Save the username to local storage to keep as a key
                        SharedPreferences sharedPreferences = getSharedPreferences(User_Name_Story, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(User_Name_Story_Local, userNameStory.getText().toString());
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "User Updated", Toast.LENGTH_SHORT).show();

                        //New Intent to go to next
                        Intent i = new Intent(chooseUserName_Activity.this, Add_Photo.class);
                        startActivity(i);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
    private void loadDataUserNameLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(User_Name_Story,MODE_PRIVATE);
        User_Name_Story_New = sharedPreferences.getString(User_Name_Story_Local, "");
    }

    public void check_Username_local(){
        if(User_Name_Story_New.isEmpty()){
            //if username is not valid

        }

        else{
            Intent i = new Intent(chooseUserName_Activity.this, Add_Photo.class);
            startActivity(i);
        }
    }
}