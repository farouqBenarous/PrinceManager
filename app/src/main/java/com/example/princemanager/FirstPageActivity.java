package com.example.princemanager;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class FirstPageActivity extends AppCompatActivity {


    ViewFlipper viewFlipper;
    ProgressBar progressBar;
    ImageView imageView1,imageView2,imageView3;
    TabledbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        dbHelper = new TabledbHelper(this) ;

        viewFlipper = findViewById(R.id.viewSwitcher);
        progressBar = (ProgressBar ) findViewById(R.id.progressbar);
        imageView1 = (ImageView) findViewById(R.id.ImageFeature1) ;
        imageView2 = (ImageView) findViewById(R.id.ImageFeature2) ;
        imageView3 = (ImageView) findViewById(R.id.ImageFeature3) ;




        viewFlipper.setFlipInterval(20000);
        viewFlipper.startFlipping();

        Picasso.with(getApplicationContext())
                .load("https://www.industryweek.com/sites/industryweek.com/files/styles/article_featured_retina/public/uploads/2017/05/teamwork.jpg?itok=U5ZihnwP")
                .into(imageView1);

        //images.unsplash.com/photo-1521737604893-d14cc237f11d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=763&q=80

        Picasso.with(getApplicationContext())
                .load("https://images.unsplash.com/photo-1521737604893-d14cc237f11d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=763&q=80")
                .into(imageView2);

        Picasso.with(getApplicationContext())
                .load("https://images.unsplash.com/photo-1522071820081-009f0129c71c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80")
                .into(imageView3);

        // Checkif the token exist in the database or not

        if (!dbHelper.isEmpty()) {
             Intent intent = new Intent(getApplicationContext() , MainActivity.class);
             startActivity(intent);

        }

    }


    public void Login (View view) {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);

    }
    public void Signup (View view) {
        Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(intent);

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
