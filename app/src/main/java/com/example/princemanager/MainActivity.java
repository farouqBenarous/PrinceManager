package com.example.princemanager;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView BottNav;
    FragmentBoard fragmentBoard = new FragmentBoard();
    FragmentInbox fragmentInbox = new FragmentInbox();
    FragmentNotifaction fragmentNotifaction = new FragmentNotifaction();
    FragmentContact fragmentContact = new FragmentContact();
    FragmentManager transaction ;

    // contact fragment attribuets
    ListView listView ;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottNav = (BottomNavigationView) findViewById(R.id.BottNav);
        Objects.requireNonNull(this.getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();



        BottNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.notification:
                                transaction = getSupportFragmentManager();
                                transaction.beginTransaction().replace(R.id.framelayout,fragmentNotifaction).commit() ;

                                break;
                            case R.id.inbox:
                                transaction = getSupportFragmentManager();
                                transaction.beginTransaction().replace(R.id.framelayout,fragmentInbox).commit() ;
                                break;
                            case R.id.board:
                                transaction = getSupportFragmentManager();
                                transaction.beginTransaction().replace(R.id.framelayout,fragmentBoard).commit() ;
                                break;
                            case R.id.contact:
                                transaction = getSupportFragmentManager();
                                transaction.beginTransaction().replace(R.id.framelayout, fragmentContact).commit();
                                break;

                        }
                        return false;
                    }
                });

    }


    public  void profile(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }

    // Fragment Contact Board







}
