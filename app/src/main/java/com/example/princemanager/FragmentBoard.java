package com.example.princemanager;


import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FragmentBoard extends Fragment {
    String id ;
    TabledbHelper dbHelper;
    String[] Menu;
    ArrayList<ModelProject> listprojects = new ArrayList<ModelProject>() ;


    public FragmentBoard() {
        // Required empty public constructor
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        ListView listView = (ListView) view.findViewById(R.id.listviewboard);
        // Create the arrays
        this.Menu = getResources().getStringArray(R.array.boardsmenu);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,Menu);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                switch (pos) {
                    case 0:
                        Intent intent = new Intent(getContext() , projectsActivity.class );
                        startActivity(intent);
                        break;
                    case 1 :
                        Toast.makeText(getContext(),"1",Toast.LENGTH_LONG).show();
                        break;

                    case 2 :
                        Toast.makeText(getContext(),"2",Toast.LENGTH_LONG).show();
                        break;

                }


            }
        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_board, container, false);
    }

    public String viewAll() {
        String id ="" ;

        Cursor res = dbHelper.getAllData();
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(getContext(),"Error"+"Nothing found" , Toast.LENGTH_LONG).show();
        }

        while (res.moveToNext()) {
            id =  res.getString(0) ;

        }
        return  id ;
    }


}
