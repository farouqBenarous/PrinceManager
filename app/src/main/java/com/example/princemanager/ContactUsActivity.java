package com.example.princemanager;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContactUsActivity extends AppCompatActivity {
    TextView Person1Email,Person2Email,Person3Email,Person4Email,Person5Email,Person1Phone,Person2Phone,Person3Phone,Person4Phone,Person5Phone;
    String   Email1 , Email2 , Email3 ,Email4 ,Phone1,Phone2,Phone3,Phone4;
    ImageView imageView1,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        imageView1 = (ImageView) findViewById(R.id.Image1);
        imageView2 = (ImageView) findViewById(R.id.Image2);
        imageView3 = (ImageView) findViewById(R.id.Image3);
        imageView4 = (ImageView) findViewById(R.id.Image4);


        Person1Email = (TextView) findViewById(R.id.Person1Email);
        Person1Phone = (TextView) findViewById(R.id.Person1Phone);

        Person2Email = (TextView) findViewById(R.id.Person2Email);
        Person2Phone = (TextView) findViewById(R.id.Person2Phone);

        Person3Email = (TextView) findViewById(R.id.Person3Email);
        Person3Phone = (TextView) findViewById(R.id.Person3Phone);

        Person4Email = (TextView) findViewById(R.id.Person4Email);
        Person4Phone = (TextView) findViewById(R.id.Person4Phone);

        Person5Email = (TextView) findViewById(R.id.Person5Email);
        Person5Phone = (TextView) findViewById(R.id.Person5Phone);








    }
}
