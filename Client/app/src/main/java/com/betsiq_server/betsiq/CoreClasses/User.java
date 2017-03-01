package com.betsiq_server.betsiq.CoreClasses;

/**
 * Created by Jacob on 11/02/2017.
 */

public class User {

    private String _id;
    private String Name;
    private String Email;

    public User(){}

    public User(String name, String email, String id){
        this._id = id;
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

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }
}
