package com.example.princemanager;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
     ImageView imageheader ;
    CircleImageView profilepic;
    TextView  FulName ,Username  , Email, Phonenumber, Gender , Birthday , Textviewteams ;
    String   TextFullName , TextUsername , Textemail , Textphonenumber ;
    TabledbHelper dbHelper;
    List<String> teams = new ArrayList<String>();




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
        Textviewteams = (TextView) findViewById(R.id.teams) ;



        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }});
        Picasso.with(getApplicationContext())
                .load("https://www.industryweek.com/sites/industryweek.com/files/styles/article_featured_retina/public/uploads/2017/05/teamwork.jpg?itok=U5ZihnwP")
                .into(imageheader);

        String id = viewAll();
        Toast.makeText(getApplicationContext(),String.valueOf(id) , Toast.LENGTH_LONG).show();
        final RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://calvin.estig.ipb.pt/projectman/api/Users/Teams/"+id;
        JsonObjectRequest jsonObjectReques = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(), new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jArray = response.getJSONArray("ListTeam");
                    for(int i = 0; i < jArray.length(); i++)
                    {
                        JSONObject obj =  jArray.getJSONObject(i);
                        teams.add(obj.getString("IdTeam"));
                    }
                    String myteams = "";

                    for (int i =0 ; i <teams.size(); i++) {
                        myteams  = myteams+ teams.get(i)+"   ";
                        Toast.makeText(getApplicationContext(),myteams , Toast.LENGTH_LONG).show();


                    }
                    Textviewteams.setText(myteams);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        } , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"That didn't work!" , Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),error.toString() , Toast.LENGTH_LONG).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectReques);

    }

    public String viewAll() {
        String id ="" ;

        Cursor res = dbHelper.getAllData();
        if(res.getCount() == 0) {
              // show message
              Toast.makeText(getApplicationContext(),"Error"+"Nothing found" , Toast.LENGTH_LONG).show();
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

          Email.setText(res.getString(3));
          Phonenumber.setText(res.getString(5));

          if  (res.getString(4) .equals("m")) {Gender.setText("Male");}
          else { Gender.setText("Female");}
          Birthday.setText(res.getString(6));
          Username.setText(res.getString(2));
          FulName.setText(res.getString(1));
          id =  res.getString(0) ;

        }
       Toast.makeText(getApplicationContext(),"Data"+buffer.toString() , Toast.LENGTH_LONG).show();
        return  id ;
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
