package com.example.photosharingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PhotoCateActivity extends AppCompatActivity {

    RecyclerView mcateList;
    category_Adapter mcateAdapter;
    ArrayList<category> mcategoryList;
    Button btnSaveCate;
    Animation btt;

    //add username_local
    String User_Name_Story = "usernamestory", User_Name_Story_Local = "", User_Name_Story_New = "";


    //setting for database
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_cate);
        btnSaveCate = (Button) findViewById(R.id.btnSaveCate);
        loadDataUserNameLocal();
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);


        mcategoryList = new ArrayList<>();
        mcategoryList.add(
                new category(
                        "Juicy",
                        R.drawable.icjuicy)
        );
        mcategoryList.add(
                new category(
                        "Price",
                        R.drawable.icprize)
        );
        mcategoryList.add(
                new category(
                        "Shopping",
                        R.drawable.icshopper)
        );
        mcategoryList.add(
                new category(
                        "Snorkling",
                        R.drawable.icsnork)
        );
        mcategoryList.add(
                new category(
                        "Study",
                        R.drawable.icstudy)
        );
        mcategoryList.add(
                new category(
                        "Travel",
                        R.drawable.ictravel)
        );


        mcateList = (RecyclerView) findViewById(R.id.my_Cate_List);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false);

        mcateList.setLayoutManager(linearLayoutManager);
        mcateList.setHasFixedSize(true);
        mcateAdapter = new category_Adapter(this, mcategoryList);
        mcateList.setAdapter(mcateAdapter);

        //Snapping from Google
        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mcateList);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolderDefault = mcateList.findViewHolderForAdapterPosition(0);
                ImageView imageView = viewHolderDefault.itemView.findViewById(R.id.iconimg);
                imageView.animate().alpha(1).scaleY(1).scaleX(1).setDuration(100).start();

                TextView textView = viewHolderDefault.itemView.findViewById(R.id.icontitle);
                textView.animate().alpha(1).setDuration(100).start();
                btnSaveCate.animate().alpha(1).setDuration(100).start();

            }
        }, 100);


        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(User_Name_Story_New);


        mcateList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);
                    RecyclerView.ViewHolder viewHolder = mcateList.findViewHolderForAdapterPosition(pos);
                    ImageView imageView = viewHolder.itemView.findViewById(R.id.iconimg);
                    imageView.animate().alpha(1).scaleY(1).scaleX(1).setDuration(100).start();

                    TextView textView = viewHolder.itemView.findViewById(R.id.icontitle);
                    textView.animate().alpha(1).setDuration(100).start();
                    btnSaveCate.animate().alpha(1);
                    btnSaveCate.startAnimation(btt);
                    btnSaveCate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           // Toast.makeText(getApplicationContext(), "btn Clicked", Toast.LENGTH_SHORT).show();

                            //Saving the category to Firebase DB
                            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    //get String from current category
                                    String storyCategory = textView.getText().toString();

                                    //save to firebase DB
                                    reference.getRef().child("category").setValue(storyCategory);
                                    Toast.makeText(getApplicationContext(), "Category Updated", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                            Intent i = new Intent(PhotoCateActivity.this, chooseUserName_Activity.class);
                            startActivity(i);
                        }
                    });
                }
                else{
                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);
                    RecyclerView.ViewHolder viewHolder = mcateList.findViewHolderForAdapterPosition(pos);
                    ImageView imageView = viewHolder.itemView.findViewById(R.id.iconimg);
                    imageView.animate().alpha(0.5f).scaleY(0.5f).scaleX(0.5f).setDuration(100).start();

                    TextView textView = viewHolder.itemView.findViewById(R.id.icontitle);
                    textView.animate().alpha(0).setDuration(100).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                btnSaveCate.animate().alpha(0);
            }
        });


    }
    private void loadDataUserNameLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(User_Name_Story,MODE_PRIVATE);
        User_Name_Story_New = sharedPreferences.getString(User_Name_Story_Local, "");
    }
}