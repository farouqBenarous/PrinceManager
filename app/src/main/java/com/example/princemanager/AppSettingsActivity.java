package com.example.princemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AppSettingsActivity extends AppCompatActivity {
    String[] Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);




        ListView listView = (ListView)findViewById(R.id.appsetings);

        // Create the arrays
        this.Menu = getResources().getStringArray(R.array.appsettings);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,Menu);
        listView.setAdapter(itemsAdapter);


        listView    .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                switch (pos) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_LONG).show();
                        break;
                    case 1 :
                        Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                        break;
                    case 3 :
                        Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                        break; }

            } } );



        } }