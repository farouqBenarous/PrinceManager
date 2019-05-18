package com.example.princemanager;

import java.util.ArrayList;

public class ModelUser {

    private String  id ;
    private String fullname;
    private  String username;
    private  String email ;
    private  String phoneNumber;
    private String imageuri;
    private  String password;


    public ModelUser (String id , String fullname , String username , String email , String phoneNumber , String imageuri) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageuri = imageuri;
    }

    public  ModelUser (String username , String password ) {
        this.username = username;
        this.password = password;

    }

    public ModelUser (String id , String fullname , String username , String email , String phoneNumber) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    private static int lastContactId = 0;

    public static ArrayList<ModelUser> createContactsList(int numContacts) {
        ArrayList<ModelUser> listusers = new ArrayList<ModelUser>();

        for (int i = 1; i <= numContacts; i++) {
            listusers.add(new ModelUser(String.valueOf(i) ,
                    "farouk "+i,
                    "Cr"+i ,
                    "fa"+i+"@gmail.com",
                    "0035193268609"+i ) );
        }

        return listusers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
