package com.example.princemanager;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

public class ContactUsActivity extends AppCompatActivity {
    TextView Person1Email,Person2Email,Person3Email,Person4Email,Person5Email,Person1Phone,Person2Phone,Person3Phone,Person4Phone,Person5Phone;
    String   Email1 , Email2 , Email3 ,Email4 ,Email5,Phone1,Phone2,Phone3,Phone4,Phone5;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        viewFlipper = findViewById(R.id.viewSwitcher);
        viewFlipper.setFlipInterval(20000);
        viewFlipper.startFlipping();




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

        Person1Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email1 = Person1Email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{Email1});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        Person1Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone1 = Person1Phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+Phone1));//change the number
                startActivity(callIntent);
            }});




        Person2Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email2 = Person2Email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{Email2});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        Person2Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone2 = Person2Phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+Phone2));//change the number
                startActivity(callIntent);
            }});






        Person3Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email3 = Person3Email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{Email3});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        Person3Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone3 = Person3Phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+Phone3));//change the number
                startActivity(callIntent);
            }});






        Person4Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email4 = Person4Email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{Email4});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        Person4Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone4 = Person4Phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+Phone4));//change the number
                startActivity(callIntent);
            }});





        Person5Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email5 = Person5Email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{Email5});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        Person5Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone5 = Person5Phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+Phone5));//change the number
                startActivity(callIntent);
            }});

    }



    public void Next (View view) {
        viewFlipper.showNext();
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();


    }
    public void Privous (View view) {
        viewFlipper.showPrevious();
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showPrevious();

    }

}
