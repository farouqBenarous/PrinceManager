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

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.ViewHolder>  {
@NonNull
@Override
public AdapterTeam.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =  viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View projectview = inflater.inflate(R.layout.item_team, viewGroup, false);

        // Return a new holder instance
        AdapterTeam.ViewHolder viewHolder = new AdapterTeam.ViewHolder(projectview);


        return viewHolder;
        }

@Override
public void onBindViewHolder(@NonNull AdapterTeam.ViewHolder viewHolder, int i) {
        // Get the data model based on position
        ModelTeam team = modelteamList.get(i);
        // Set item views based on your views and data model

        TextView teamname = viewHolder.teamname;
        teamname.setText(" Team  Name : "+team.getName());

        TextView idteam = viewHolder.idteam;
        idteam.setText("Id team" + team.getId());

       TextView idproject = viewHolder.idproject;
       idproject.setText("Id project : " + team.getIdproject());

       TextView CreationDate = viewHolder.CreationDate;
       CreationDate.setText("CreationDate : "+ team.getCreationdata());

        }

@Override
public int getItemCount() {
        return modelteamList.size();
        }


public class ViewHolder extends RecyclerView.ViewHolder {
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    ImageView profleimage;
    TextView teamname , idteam , idproject , CreationDate ;



    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public ViewHolder(View itemView) {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);
        profleimage =(ImageView) itemView.findViewById(R.id.profleimage);
        teamname = (TextView) itemView.findViewById(R.id.teamname);
        idteam = (TextView) itemView.findViewById(R.id.idteam);
        idproject = (TextView) itemView.findViewById(R.id.idproject);
        CreationDate = (TextView) itemView.findViewById(R.id.CreationDate);
    }
}

    private List<ModelTeam> modelteamList;

    public AdapterTeam(List<ModelTeam>  ModelTeam) {
        modelteamList = ModelTeam;
    }


}

