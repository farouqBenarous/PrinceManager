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

    String[] Menu;


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


        listView    .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                switch (pos) {
                    case 0:
                        Toast.makeText(getContext(),"0",Toast.LENGTH_LONG).show();
                        break;
                    case 1 :
                        Toast.makeText(getContext(),"1",Toast.LENGTH_LONG).show();
                        break;




                }


            }
        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_board, container, false);
    }

}
