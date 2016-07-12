package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class UserResponse implements Serializable {
    @SerializedName("response")
    private ArrayList<User> mUsers;

    public UserResponse(ArrayList<User> users) {
        mUsers = users;
    }

    public ArrayList<User> getUsers() {
        return mUsers;
    }

    public void setUsers(ArrayList<User> users) {
        this.mUsers = users;
    }
}
