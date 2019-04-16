package com.example.princemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.angmarch.views.NiceSpinner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileEditActivity extends Activity {
    NiceSpinner niceSpinner;
    List<String> dataset;
    EditText Email,FullName,UserName,Phonenumber,OldPassword,NewPassword,ConfirmPassword;
    String TextEmail,TextFullName,TextUserName,TextPhonenumber,TextOldPassword,TextNewPassword,TextConfirmPassword,RightPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);


        Email = (EditText) findViewById(R.id.Email);
        FullName = (EditText) findViewById(R.id.FullName);
        UserName = (EditText) findViewById(R.id.UserName);
        Phonenumber = (EditText) findViewById(R.id.PhoneNumber);

        OldPassword = (EditText) findViewById(R.id.Password);
        NewPassword = (EditText) findViewById(R.id.NewPassword);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

    }



    public void Save(View view) {
        TextEmail = String.valueOf(Email.getText());
        TextFullName = String.valueOf(FullName.getText());
        TextUserName = String.valueOf(UserName.getText());
        TextPhonenumber = String.valueOf(Phonenumber.getText());

        TextOldPassword = String.valueOf(OldPassword.getText());
        TextNewPassword = String.valueOf(NewPassword.getText());
        TextConfirmPassword = String.valueOf(ConfirmPassword.getText());

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
        if (PhoneNumberUtils.isGlobalPhoneNumber(TextPhonenumber)) {
            Phonenumber.setError("Phone number is not Valid ");
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }





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
            OldPassword.setError("The Password does't match ");
            progressBar.setVisibility(View.INVISIBLE);
            return ;
        }

        Toast.makeText(getApplicationContext(),"Successfully Saved the Changes " , Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);



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
