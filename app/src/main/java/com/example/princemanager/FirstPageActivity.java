package com.example.princemanager;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        viewFlipper = findViewById(R.id.viewSwitcher);
        progressBar = (ProgressBar ) findViewById(R.id.progressbar);
        imageView1 = (ImageView) findViewById(R.id.ImageFeature1) ;


        viewFlipper.setFlipInterval(20000);
        viewFlipper.startFlipping();

        Picasso.with(getApplicationContext())
                .load("https://www.google.pt/search?q=teamwork&client=opera&hs=F8E&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjZiuqw78DhAhWvx4UKHUUbD68Q_AUIDigB&biw=1326&bih=605#imgrc=5k9Nn6gXY5ZhUM:")
                .resize(50, 50)
                .centerCrop()
                .into(imageView1);

                        // Checkif the token exist in the database or not

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
