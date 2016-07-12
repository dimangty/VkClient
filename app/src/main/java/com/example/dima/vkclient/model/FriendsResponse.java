package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 09.07.16.
 */
public class FriendsResponse implements Serializable {
    @SerializedName("response")
    private Friends mFriends;

    public FriendsResponse(Friends friends) {
        mFriends = friends;
    }

    public Friends getFriends() {
        return mFriends;
    }

    public void setFriends(Friends friends) {
        this.mFriends = friends;
    }
}
