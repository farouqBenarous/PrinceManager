package com.example.princemanager;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FragmentBoard extends Fragment {

    ListView listView;
    List<String> list= new ArrayList<String>();
    ArrayAdapter<String> adapter;


    public FragmentBoard() {
        // Required empty public constructor
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.listviewboard);
        adapter = new ArrayAdapter<String>(Objects.requireNonNull(getContext()),android.R.layout.simple_list_item_1);
        list.add("Projects");
        list.add("Tasks");
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        Toast.makeText(getContext() , "1"+position,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getContext() , "2"+position,Toast.LENGTH_LONG).show();
                        break;

                    case  3:
                        Toast.makeText(getContext() , "2"+position,Toast.LENGTH_LONG).show();
                        break;


                } }});






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_board, container, false);
    }

}
