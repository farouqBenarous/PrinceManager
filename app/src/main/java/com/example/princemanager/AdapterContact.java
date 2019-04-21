package com.example.princemanager;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder> {
    @NonNull
    @Override
    public AdapterContact.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =  viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, viewGroup, false);

        // Return a new holder instance
        AdapterContact.ViewHolder viewHolder = new AdapterContact.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHolder viewHolder, int i) {
        // Get the data model based on position
        ModelUser modelUser = modeluserslist.get(i);

        // Set item views based on your views and data model

        TextView fullnameusername = viewHolder.fullnameusername;
        fullnameusername.setText(modelUser.getFullname() +" ( "+modelUser.getUsername() +" ) ");

        TextView email = viewHolder.email;
        email.setText(modelUser.getEmail());

        TextView phonenumber = viewHolder.PhoneNumber;
        phonenumber.setText(modelUser.getPhoneNumber());




    }

    @Override
    public int getItemCount() {
        return modeluserslist.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        ImageView profleimage;
        TextView fullnameusername;
        TextView email;
        TextView PhoneNumber;



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            profleimage =(ImageView) itemView.findViewById(R.id.profleimage);
            fullnameusername = (TextView) itemView.findViewById(R.id.fullnameusername);
            email = (TextView) itemView.findViewById(R.id.email);
            PhoneNumber = (TextView) itemView.findViewById(R.id.PhoneNumber);

        }
    }

    private List<ModelUser> modeluserslist;

    public AdapterContact(List<ModelUser>  ModelUser) {
        modeluserslist = ModelUser;
    }
}
