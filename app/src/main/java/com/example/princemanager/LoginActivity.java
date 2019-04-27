package com.example.princemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText email , password;
    String EmailText , PasswordText,RightPassword;
    CheckBox checkBox;
    ProgressBar progressBar;
    boolean checked ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        progressBar = (ProgressBar)  findViewById(R.id.progressbar) ;


    }


    public void Login (View view) {
        EmailText = String.valueOf(email.getText());
        PasswordText = String.valueOf(password.getText());
        checked = checkBox.isChecked();

        progressBar.setVisibility(View.VISIBLE);


        if (EmailText.isEmpty() || EmailText == null ) {
            email.setError("You have To set the Email ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        if (!isValidEmail(EmailText) ) {

           email.setError("You have To set a Correct Email !");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        if (PasswordText.isEmpty() || PasswordText == null) {
            password.setError("You Have To set the password !");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        // method to check if the  password is correct or not send an http request and return the hash and compare it

        if (! PasswordText.equals(RightPassword)) {
             password.setError("Wrong Password !");
            progressBar.setVisibility(View.INVISIBLE);
            return;  }

        if (checked) {
            // Create a token in an sqlite database
        }

        progressBar.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);

    }

    public void gohome(View view) {

        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);


    }
    public void Gosignup(View view ) {
        Intent intent =new Intent(getApplicationContext() , SignupActivity.class);
        startActivity(intent);

    }


    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


}
