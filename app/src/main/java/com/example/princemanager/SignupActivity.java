package com.example.princemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.angmarch.views.NiceSpinner;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupActivity extends AppCompatActivity {
    NiceSpinner niceSpinner,dayspin,monthspin,yearspin;
    List<String> datasetgender , datasetday , datasetmonth , datasetyear  ;
    EditText Email,FullName,UserName,Phonenumber,Password,ConfirmPassword;
    String TextEmail,TextFullName,TextUserName,TextPhonenumber,TextPassword,TextConfirmPassword;
    ProgressBar progressBar;
    int spin,day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Email = (EditText) findViewById(R.id.Email);
        FullName = (EditText) findViewById(R.id.FullName);
        UserName = (EditText) findViewById(R.id.UserName);
        Phonenumber = (EditText) findViewById(R.id.PhoneNumber);
        Password = (EditText) findViewById(R.id.Password);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        dayspin = (NiceSpinner) findViewById(R.id.day);
        monthspin = (NiceSpinner) findViewById(R.id.month);
        yearspin = (NiceSpinner) findViewById(R.id.year);

         datasetgender = new LinkedList<>(Arrays.asList("Male", "Female"));
        niceSpinner.attachDataSource(datasetgender);
        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spin = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        datasetday  = new LinkedList<>(Arrays.asList("1"));
        for (int i =1 ; i <= 31 ;i++) { datasetday.add(String.valueOf(i));}
        dayspin.attachDataSource(datasetday);
        dayspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        datasetmonth = new LinkedList<>(Arrays.asList("1"));
        for (int i =1 ; i <= 11 ;i++) { datasetmonth.add(String.valueOf(i));}
        monthspin.attachDataSource(datasetmonth);
        monthspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        datasetyear = new LinkedList<>(Arrays.asList("1960"));
        for (int i =1961 ; i <= 2019 ;i++) { datasetyear.add(String.valueOf(i)); }
        yearspin.attachDataSource(datasetyear);
        yearspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    public void Signup (View view) throws JSONException {
        TextEmail = String.valueOf(Email.getText());
        TextFullName = String.valueOf(FullName.getText());
        TextUserName = String.valueOf(UserName.getText());
        TextPhonenumber = String.valueOf(Phonenumber.getText());
        TextPassword = String.valueOf(Password.getText());
        TextConfirmPassword = String.valueOf(ConfirmPassword.getText());
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

        /*if (PhoneNumberUtils.isGlobalPhoneNumber(TextPhonenumber)) {
            Phonenumber.setError("Phone number is not Valid ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        } */


        if (TextPassword.isEmpty() || TextPassword == null) {
            Password.setError("You have To set the Confirm Password ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (TextConfirmPassword.isEmpty() || TextConfirmPassword == null) {
            ConfirmPassword.setError("You have To set the Confirm Password ! ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        if (!TextConfirmPassword.equals(TextPassword)) {
            Password.setError("The Password does't match ");
            progressBar.setVisibility(View.INVISIBLE);
            return ;
        }


        // Instantiate the RequestQueue.
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url ="https://calvin.estig.ipb.pt/projectman/api/Users";
        String birthdate = day+"/"+month+"/"+year ;

        final ModelUser user = new ModelUser("0",datasetgender.get(spin),TextFullName,TextUserName,TextEmail,TextPhonenumber ,birthdate , TextPassword) ;
        Gson gson = new Gson();
        String json = gson.toJson(user);

        final JSONObject User = new JSONObject();
        User.put("name",TextFullName);
        User.put("email",TextEmail);
        User.put("bornDate",birthdate);
        User.put("phone",TextPhonenumber);
        User.put("username",TextUserName);
        if (datasetgender.get(spin).equals("Male")) {        User.put("gender","m"); }
        else User.put("gender","f");
        User.put("Password",TextPassword);
       /* {
            "name": "User21",
                "email": "user133@princemanager.com                 ",
                "bornDate": "2011-01-01T00:00:00",
                "phone": "11111111       ",
                "username": "username232",
                "password": "asdaasda",
                "gender": "m",
                "date_add": "2011-01-01T00:00:00"
        } */

        JsonObjectRequest jsonObjectReques = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(String.valueOf(User)), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),"Response is: " + String.valueOf(response),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        } , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(getApplicationContext(),"That didn't work!" , Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),String.valueOf(User), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),error.toString() , Toast.LENGTH_LONG).show();



            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectReques);



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
