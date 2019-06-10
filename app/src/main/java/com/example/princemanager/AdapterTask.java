package com.example.princemanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class  AdapterTask extends  RecyclerView.Adapter<AdapterTask.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =  viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View projectview = inflater.inflate(R.layout.item_task, viewGroup, false);

        // Return a new holder instance
        AdapterTask.ViewHolder viewHolder = new AdapterTask.ViewHolder(projectview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Get the data model based on position
        ModelTask task = modeltaskList.get(i);
        // Set item views based on your views and data model

        TextView taskname = viewHolder.taskname;
        taskname.setText("Task Title : "+task.getName());

        TextView Duration = viewHolder.Duration;
        Duration.setText("Duration : "+task.getDuration());

        TextView IdTeam = viewHolder.IdTeam;
        IdTeam.setText("IdTeam : "+task.getIdteam());

        TextView IdResponsible = viewHolder.IdResponsible;
        IdResponsible.setText("IdResponsible : "+task.getIdreponsible());

        TextView Expired = viewHolder.creationDate;
        Expired.setText("creationDate " + task.getCreationdate());

    }

    @Override
    public int getItemCount() {
        return  modeltaskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        ImageView profleimage;
        TextView taskname , Duration , IdTeam , IdResponsible , creationDate ;



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            profleimage =(ImageView) itemView.findViewById(R.id.profleimage);
            taskname = (TextView) itemView.findViewById(R.id.taskname);
            Duration = (TextView) itemView.findViewById(R.id.Duration);
            IdTeam = (TextView) itemView.findViewById(R.id.IdTeam);
            IdResponsible = (TextView) itemView.findViewById(R.id.IdResponsible);
            creationDate= (TextView) itemView.findViewById(R.id.creationDate);

        }
    }



    private List<ModelTask> modeltaskList;

    public AdapterTask(List<ModelTask>  ModelTask) {
        modeltaskList = ModelTask;
    }





}
