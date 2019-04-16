package com.example.princemanager;

import android.app.ActionBar;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
     ImageView imageheader ;
    CircleImageView profilepic;
    TextView  FulName ,Username , Location ;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageheader = (ImageView) findViewById(R.id.header_cover_image);
        profilepic = (CircleImageView) findViewById(R.id.profilepic);
        FulName = (TextView) findViewById(R.id.fullname);
        Username = (TextView) findViewById(R.id.username);
        Location = (TextView) findViewById(R.id.location);




         Picasso.with(getApplicationContext())
                .load("https://www.industryweek.com/sites/industryweek.com/files/styles/article_featured_retina/public/uploads/2017/05/teamwork.jpg?itok=U5ZihnwP")
                .into(imageheader);

    }

 public void Editprofile(View view) {
         Intent intent = new Intent(getApplicationContext(),ProfileEditActivity.class);
         startActivity(intent);

 }
}
