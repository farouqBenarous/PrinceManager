package com.example.princemanager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.angmarch.views.NiceSpinner;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileEditActivity extends Activity {
    NiceSpinner niceSpinner;
    List<String> dataset;
    EditText Email,FullName,UserName,Phonenumber,OldPassword,NewPassword,ConfirmPassword;
    String TextEmail,TextFullName,TextUserName,TextPhonenumber,TextOldPassword,TextNewPassword,TextConfirmPassword,RightPassword;
    ProgressBar progressBar;
    TabledbHelper dbHelper;
    ModelUser user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        dbHelper = new TabledbHelper(this) ;



        Email = (EditText) findViewById(R.id.Email);
        FullName = (EditText) findViewById(R.id.FullName);
        UserName = (EditText) findViewById(R.id.UserName);
        Phonenumber = (EditText) findViewById(R.id.PhoneNumber);

        OldPassword = (EditText) findViewById(R.id.Password);
        NewPassword = (EditText) findViewById(R.id.NewPassword);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        user = viewAll();

    }



    public void Save(View view) throws JSONException {
        TextEmail = String.valueOf(Email.getText());
        TextFullName = String.valueOf(FullName.getText());
        TextUserName = String.valueOf(UserName.getText());
        TextPhonenumber = String.valueOf(Phonenumber.getText());

        TextOldPassword = String.valueOf(OldPassword.getText());
        TextNewPassword = String.valueOf(NewPassword.getText());
        TextConfirmPassword = String.valueOf(ConfirmPassword.getText());

        RightPassword = user.getPassword();
        RightPassword = RightPassword.trim();
        // RightPassword i have to get the right password here

        progressBar.setVisibility(View.VISIBLE);

        if (TextEmail.isEmpty() || TextEmail == null ) {
            Email.setError("You have To set the Email ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (!isValidEmail(TextEmail) ) {

            Email.setError("You have To set a Correct Email !");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (TextFullName.isEmpty() || TextFullName == null) {
            FullName.setError("You have To set the FullName ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (! isValidName(TextFullName)) {
            FullName.setError("You have To set a Correct  FullName ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }



        if (TextUserName.isEmpty() || TextUserName == null) {
            UserName.setError("You have To set the UserName ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (TextPhonenumber.isEmpty() || TextPhonenumber == null) {
            Phonenumber.setError("You have To set the Phonenumber ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        /*
        if (PhoneNumberUtils.isGlobalPhoneNumber(TextPhonenumber)) {
            Phonenumber.setError("Phone number is not Valid ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        } */





        if (TextOldPassword.isEmpty() || TextOldPassword == null) {
            OldPassword.setError("You have To set the Password ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        if (! TextOldPassword.equals(RightPassword)) {
            OldPassword.setError("The Password does't match with the old one  ");
            progressBar.setVisibility(View.INVISIBLE);
            return ;
        }




        if (TextNewPassword.isEmpty() || TextNewPassword == null) {
            OldPassword.setError("You have To set the Password ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        if (TextConfirmPassword.isEmpty() || TextConfirmPassword == null) {
            ConfirmPassword.setError("You have To set the Confirm Password ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (! TextConfirmPassword.equals(TextNewPassword)) {
            NewPassword.setError("The Password does't match ");
            ConfirmPassword.setError("The Password does't match ");
            progressBar.setVisibility(View.INVISIBLE);
            return ;
        }



        final RequestQueue queue = Volley.newRequestQueue(this);
        final String id= user.getId();
        final String url ="https://calvin.estig.ipb.pt/projectman/api/Users/"+id;
        final JSONObject U = new JSONObject();
        /*
        {
                "Id": 101,
                "Name": "aa",
                "Email": "hh@princemanager.com                 ",
                "BornDate": "2011-01-01T00:00:00",
                "Phone": "4545       ",
                "Username": "hh     ",
                "Password": "hh",
                "Gender": "m"

        } */
        U.put("Id" , id);
        U.put("Name",TextFullName);
        U.put("Email",TextEmail);
        U.put("BornDate",user.getBirthdate());
        U.put("Phone",TextPhonenumber);
        U.put("Username",TextUserName);
        U.put("Password",TextNewPassword);
        U.put("Gender",user.getGender());

        JsonObjectRequest jsonObjectReques ;
        jsonObjectReques = new JsonObjectRequest(Request.Method.PUT,url,new JSONObject(String.valueOf(U)), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),"Response is: ",Toast.LENGTH_LONG).show();
                dbHelper.deleteData();

                boolean isInserted = false;
                dbHelper.deleteData();
                isInserted = dbHelper.insert(id,TextFullName,TextUserName,TextEmail ,user.getGender(),TextPhonenumber, user.getBirthdate(),TextNewPassword);

                if(isInserted) {
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show(); }
                else {
                    Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show(); }


                Toast.makeText(getApplicationContext(),"Successfully Saved the Changes " , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

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
        dbHelper.deleteData();

        boolean isInserted = false;
        dbHelper.deleteData();
        isInserted = dbHelper.insert(id,TextFullName,TextUserName,TextEmail ,user.getGender(),TextPhonenumber, user.getBirthdate(),TextNewPassword);

        if(isInserted) {
            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show(); }
        else {
            Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show(); }


        Toast.makeText(getApplicationContext(),"Successfully Saved the Changes " , Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);




    }

    public ModelUser viewAll() {
        ModelUser user = null;

        Cursor res = dbHelper.getAllData();
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(getApplicationContext(),"Error"+"Nothing found" , Toast.LENGTH_LONG).show();
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            user = new ModelUser(res.getString(0),res.getString(4) ,res.getString(1) , res.getString(2) , res.getString(3) ,
                    res.getString(5) , res.getString(6), res.getString(7));

        }
        Toast.makeText(getApplicationContext(),"Data"+buffer.toString() , Toast.LENGTH_LONG).show();


    return user ;
    }



    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidName (String Name) {
        Pattern pattern = Pattern.compile(new String ("^[a-zA-Z\\s]*$"));
        Matcher matcher = pattern.matcher(Name);
        if(!matcher.matches())
        {
            return  false;
        }
        return true ;

    }
}
