package com.example.princemanager;

public class ModelTeam {
    private String id  ;
    private String name ;
    private  String description;
    private  String creationdata ;
    private  String idproject ;
    private  String idteamleader ;
    private  String project ;
    private  String leader ;

    public ModelTeam (String id  , String name , String description , String creationdata , String idproject , String idteamleader , String project , String leader) {
        this.id = id ;
        this.name = name ;
        this.description = description;
        this.creationdata = creationdata ;
        this.idproject = idproject ;
        this.idteamleader = idteamleader ;
        this.project = project ;
        this.leader = leader ;
    }

    public ModelTeam (String id  , String name , String description , String creationdata , String idproject , String idteamleader ) {
        this.id = id ;
        this.name = name ;
        this.description = description;
        this.creationdata = creationdata ;
        this.idproject = idproject ;
        this.idteamleader = idteamleader ;
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

    public String getCreationdata() {
        return creationdata;
    }

    public void setCreationdata(String creationdata) {
        this.creationdata = creationdata;
    }

    public String getIdproject() {
        return idproject;
    }

    public void setIdproject(String idproject) {
        this.idproject = idproject;
    }

    public String getIdteamleader() {
        return idteamleader;
    }

    public void setIdteamleader(String idteamleader) {
        this.idteamleader = idteamleader;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }






    /* {
    "Id": 3,
    "Name": "Team1sd                       ",
    "Description": "Teamdsdsdsdsds                                                                                                                                                                                                                                                                                              ",
    "CreationDate": "2019-04-30T10:53:10.507",
    "IdProject": 1,
    "IdTeamLeader": 3,
    "Project": null,
    "Leader": null
} */
}
