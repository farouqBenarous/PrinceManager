package com.example.princemanager;

public class ModelProject {

    private String Id;
    private  String Name ;
    private  String Description ;
    private  String  CreationDate ;
    private String IdOwner;
    private String user ;

    public ModelProject (String Id , String Name  , String Description , String CreationDate , String IdOwner , String user ) {
        this.Id = Id ;
        this.Name = Name ;
        this.Description = Description ;
        this.CreationDate = CreationDate;
        this.IdOwner = IdOwner ;
        this.user = user ;
    }
    public ModelProject (String Id , String Name  , String Description , String CreationDate , String IdOwner  ) {
        this.Id = Id ;
        this.Name = Name ;
        this.Description = Description ;
        this.CreationDate = CreationDate;
        this.IdOwner = IdOwner ;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getIdOwner() {
        return IdOwner;
    }

    public void setIdOwner(String idOwner) {
        IdOwner = idOwner;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }



}
