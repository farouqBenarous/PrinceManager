package com.example.princemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SignupActivity extends AppCompatActivity {
    NiceSpinner niceSpinner;
    List<String> dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


         niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
         dataset = new LinkedList<>(Arrays.asList("Male", "Female"));
        niceSpinner.attachDataSource(dataset);


    }

    public void Signup (View view) {



        Toast.makeText(getApplicationContext(), "button is working", Toast.LENGTH_SHORT).show();
}

}
