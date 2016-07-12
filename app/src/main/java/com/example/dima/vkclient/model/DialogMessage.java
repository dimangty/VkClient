package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 11.07.16.
 */
public class DialogMessage implements Serializable {
    @SerializedName("id")
    private int mId;

    @SerializedName("date")
    private int mDate;

    @SerializedName("out")
    private int mOut;

    @SerializedName("user_id")
    private int mUserId;

    @SerializedName("read_state")
    private int mReadState;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;


    private User mUser;

    public DialogMessage(int id, int date, int out, int userId, int readState, String title, String body) {
        mId = id;
        mDate = date;
        mOut = out;
        mUserId = userId;
        mReadState = readState;
        mTitle = title;
        mBody = body;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getDate() {
        return mDate;
    }

    public void setDate(int date) {
        this.mDate = date;
    }

    public int getOut() {
        return mOut;
    }

    public void setOut(int out) {
        this.mOut = out;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    public int getReadState() {
        return mReadState;
    }

    public void setReadState(int readState) {
        this.mReadState = readState;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        this.mBody = body;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        this.mUser = user;
    }
}
