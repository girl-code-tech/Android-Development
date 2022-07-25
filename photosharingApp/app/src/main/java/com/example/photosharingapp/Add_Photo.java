package com.example.photosharingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Add_Photo extends AppCompatActivity {

    ImageView imageView, photoStory;
    TextView textView, TV_Review, title, subtitle;
    Button btn_Continue, btn_add_picture;
    int photomax = 1;
    Uri pictureLocation;
    DatabaseReference reference;
    StorageReference storageReference;

    String User_Name_Story = "usernamestory", User_Name_Story_Local = "", User_Name_Story_New = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
        
        //Loading UserName
        
        loadDataUserNameLocal();

        imageView = (ImageView) findViewById(R.id.imageView);
        photoStory = (ImageView) findViewById(R.id.IV_review);
        textView = (TextView) findViewById(R.id.textView);
        TV_Review = (TextView) findViewById(R.id.TV_review);
        title = (TextView) findViewById(R.id.title);
        subtitle = (TextView) findViewById(R.id.subtitle);
        btn_add_picture = (Button) findViewById(R.id.btn_add_picture);
        btn_Continue = (Button) findViewById(R.id.btn_continue);


        btn_Continue.setAlpha(0);
        TV_Review.setAlpha(0);


        btn_add_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPhoto();
            }
        });

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavePhotoToFirebaseStorage();
            }
        });



    }

    private void loadDataUserNameLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(User_Name_Story,MODE_PRIVATE);
        User_Name_Story_New = sharedPreferences.getString(User_Name_Story_Local, "");
    }


    public void findPhoto(){
        Intent pic = new Intent();
        pic.setType("image/*");
        pic.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(pic, photomax);
    }

    String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }



    public void SavePhotoToFirebaseStorage(){

        reference = FirebaseDatabase.getInstance().getReference().child("Users")
                .child(User_Name_Story_New);

        storageReference = FirebaseStorage.getInstance().getReference().child("Users")
                .child(User_Name_Story_New);

        if (pictureLocation != null){
            StorageReference storageReference1 = storageReference.child(System.currentTimeMillis()
                    + "." + getFileExtension(pictureLocation));

            storageReference1.putFile(pictureLocation)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            String uripicture = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                            reference.getRef().child("picture").setValue(uripicture);
                        }
                    });

            Toast.makeText(getApplicationContext(), "Picture Uploaded", Toast.LENGTH_SHORT).show();
            btn_Continue.animate().alpha(0).setDuration(350).start();


        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == photomax && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageView.animate().alpha(0).setDuration(350).start();
            btn_add_picture.animate().alpha(0).setDuration(350).start();
            title.animate().alpha(0).setDuration(350).start();
            subtitle.animate().alpha(0).setDuration(350).start();

            btn_Continue.animate().alpha(1).setDuration(350).start();
            TV_Review.animate().alpha(1).setDuration(350).start();


            //Testing Username Local

            //TV_Review.setText(User_Name_Story_New);

            pictureLocation = data.getData();
            Picasso.with(this).load(pictureLocation).centerCrop().fit().into(photoStory);
        }
    }
}