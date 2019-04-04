package com.example.princemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void Login (View view) {
        Toast.makeText(getApplicationContext(), "Sign up button is working", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(getApplicationContext() , MainActivity.class);
         startActivity(intent);
    }
}
