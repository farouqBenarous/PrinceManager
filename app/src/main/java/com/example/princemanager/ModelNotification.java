package com.example.princemanager;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class ModelNotification {

    private String id ;
    private String type;
    private String text;
    private String time;





    public ModelNotification(String id , String type , String text , String time) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.time = time;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private static int lastContactId = 0;

    public static ArrayList<ModelNotification> createContactsList(int numContacts) {
        ArrayList<ModelNotification> listNot = new ArrayList<ModelNotification>();

        for (int i = 1; i <= numContacts; i++) {
            listNot.add(new ModelNotification(String.valueOf(lastContactId+1), "basic","Bla bla bla","20 : "+i) );
        }

        return listNot;
    }
}
