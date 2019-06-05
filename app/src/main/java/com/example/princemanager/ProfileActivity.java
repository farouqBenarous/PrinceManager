package com.example.princemanager;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
     ImageView imageheader ;
    CircleImageView profilepic;
    TextView  FulName ,Username  , Email, Phonenumber, Gender , Birthday ;
    String   TextFullName , TextUsername , Textemail , Textphonenumber ;
    TabledbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dbHelper = new TabledbHelper(this) ;
        profilepic = (CircleImageView) findViewById(R.id.Image1);
        imageheader = (ImageView) findViewById(R.id.header_cover_image);
        FulName = (TextView) findViewById(R.id.Name);
        Username = (TextView) findViewById(R.id.username);

        Email = (TextView) findViewById(R.id.email);
        Phonenumber = ( TextView) findViewById(R.id.PhoneNumber);
        Gender = (TextView) findViewById(R.id.gender);
        Birthday = (TextView) findViewById(R.id.Birthdate);

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }});
        Picasso.with(getApplicationContext())
                .load("https://www.industryweek.com/sites/industryweek.com/files/styles/article_featured_retina/public/uploads/2017/05/teamwork.jpg?itok=U5ZihnwP")
                .into(imageheader);

        viewAll();

    }

    public void viewAll() {

        Cursor res = dbHelper.getAllData();
        if(res.getCount() == 0) {
              // show message
              Toast.makeText(getApplicationContext(),"Error"+"Nothing found" , Toast.LENGTH_LONG).show();
              return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
          /*
          buffer.append("Id :"+ res.getString(0)+"\n");
          buffer.append("Name :"+ res.getString(1)+"\n");
          buffer.append("Surname :"+ res.getString(2)+"\n");
          buffer.append("Marks :"+ res.getString(3)+"\n\n");
          */
          Email.setText(res.getString(3));
          Phonenumber.setText(res.getString(5));

          if  (res.getString(4) .equals("m")) {Gender.setText("Male");}
          else { Gender.setText("Female");}
          Birthday.setText(res.getString(6));
          Username.setText(res.getString(2));
          FulName.setText(res.getString(1));



        }
       Toast.makeText(getApplicationContext(),"Data"+buffer.toString() , Toast.LENGTH_LONG).show();
    }


    public void Logout(View view) {
        dbHelper.deleteData();
        Toast.makeText(getApplicationContext(),"Logout successfully ",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext() , LoginActivity.class);
        startActivity(intent);



    }


 public void Editprofile(View view) {
         Intent intent = new Intent(getApplicationContext(),ProfileEditActivity.class);
         startActivity(intent);

 }
}
