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

public class AdapterProjects  extends RecyclerView.Adapter<AdapterProjects.ViewHolder> {
    @NonNull
    @Override
    public AdapterProjects.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =  viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View projectview = inflater.inflate(R.layout.item_project, viewGroup, false);

        // Return a new holder instance
        AdapterProjects.ViewHolder viewHolder = new AdapterProjects.ViewHolder(projectview);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProjects.ViewHolder viewHolder, int i) {
        // Get the data model based on position
        ModelProject project = modelProjectList.get(i);
        // Set item views based on your views and data model

        TextView projectname = viewHolder.projectname;
        projectname.setText(project.getName() +" ( "+String.valueOf(project.getId())+" ) ");

        TextView projectowner = viewHolder.projectowner;
        projectowner.setText(project.getIdOwner());

        TextView CreationDate = viewHolder.CreationDate;
        CreationDate.setText(project.getCreationDate());

    }

    @Override
    public int getItemCount() {
        return modelProjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        ImageView profleimage;
        TextView projectname , projectowner , CreationDate ;



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            profleimage =(ImageView) itemView.findViewById(R.id.profleimage);
            projectname = (TextView) itemView.findViewById(R.id.projectname);
            projectowner = (TextView) itemView.findViewById(R.id.projectowner);
            CreationDate = (TextView) itemView.findViewById(R.id.CreationDate);
        }
    }

    private List<ModelProject> modelProjectList;

    public AdapterProjects(List<ModelProject>  ModelProject) {
        modelProjectList = ModelProject;
    }

}
