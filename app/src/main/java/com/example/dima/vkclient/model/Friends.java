package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 08.07.16.
 */
public class Friends implements Serializable {

    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<User> mUsers;

    public Friends(int count, ArrayList<User> users) {
        mCount = count;
        mUsers = users;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }


    public ArrayList<User> getUsers() {
        return mUsers;
    }

    public void setUsers(ArrayList<User> users) {
        this.mUsers = users;
    }
}
