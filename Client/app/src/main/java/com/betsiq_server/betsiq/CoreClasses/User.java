package com.betsiq_server.betsiq.CoreClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Jacob on 11/02/2017.
 */

public class User {
    @JsonProperty(value="_id")
    private String _id;
    private String Name;
    private String Email;

    public User(){}

    public User(String name, String email, String _id){
        this._id = _id;
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

    public void setId(String _id) {
        this._id = _id;
    }
}
