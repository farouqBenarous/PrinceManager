package com.example.princemanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =  viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_notification, viewGroup, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Get the data model based on position
        ModelNotification notification = modelNotificationslist.get(i);

        // Set item views based on your views and data model
        TextView timenotification = viewHolder.timenotification;
        timenotification.setText(notification.getTime().toString());

        TextView textnotification = viewHolder.textnotification;
        textnotification.setText(notification.getText());

    }

    @Override
    public int getItemCount() {
        return modelNotificationslist.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView timenotification;
        public TextView textnotification;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            timenotification = (TextView) itemView.findViewById(R.id.timenotification);
            textnotification = (TextView) itemView.findViewById(R.id.textnotification);
        }
    }

    private List<ModelNotification> modelNotificationslist;

    public AdapterNotification(List<ModelNotification>  notifications) {
        modelNotificationslist = notifications;
    }



}
