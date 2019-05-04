package com.example.princemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {
    TextView email,phone;
    String  textemail , textphone;
    ImageView imageView1,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


       email.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               textemail = email.getText().toString();
           }
       });

       phone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               textphone = phone.getText().toString();

           }
       });


    }
}
