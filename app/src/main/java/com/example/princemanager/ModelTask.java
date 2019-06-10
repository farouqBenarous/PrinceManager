package com.example.princemanager;

public class ModelTask {

    private String id, name, description, duration, idteam, idassigned, idreponsible, team, responsible, assigned , creationdate;

    public ModelTask(String id, String name, String description, String duration, String idteam, String idassigned, String idreponsible, String team, String responsible, String assigned) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.idteam = idteam;
        this.idassigned = idassigned;
        this.idreponsible = idreponsible;
        this.team = team;
        this.responsible = responsible;
        this.assigned = assigned;
    }

    public ModelTask(String id, String name, String description, String duration, String idteam, String idassigned, String idreponsible , String creationdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.idteam = idteam;
        this.idassigned = idassigned;
        this.idreponsible = idreponsible;
        this.creationdate = creationdate ;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIdteam() {
        return idteam;
    }

    public void setIdteam(String idteam) {
        this.idteam = idteam;
    }

    public String getIdassigned() {
        return idassigned;
    }

    public void setIdassigned(String idassigned) {
        this.idassigned = idassigned;
    }

    public String getIdreponsible() {
        return idreponsible;
    }

    public void setIdreponsible(String idreponsible) {
        this.idreponsible = idreponsible;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }
}


