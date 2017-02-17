package com.betsiq_server.betsiq.CoreClasses;

/**
 * Created by Jacob on 11/02/2017.
 */

public class User {

    private String id = null;
    private String Name;
    private String Email;

    public User(String name, String email){
        this.id = null;
        this.Name = name;
        this.Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
