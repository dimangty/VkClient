package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 * id: 391915,
 * body: 'Test message',
 * user_id: 2314852,
 * from_id: 2314852,
 * date: 1422777065,
 * read_state: 0,
 * out: 0
 */
public class Message implements Serializable {
    @SerializedName("id")
    private int mId;

    @SerializedName("body")
    private String mBody;

    @SerializedName("user_id")
    private int mUserId;

    @SerializedName("from_id")
    private int mFromId;


    @SerializedName("date")
    private int mDate;

    @SerializedName("read_state")
    private int mReadState;

    @SerializedName("out")
    private int mOut;


    private User mUser;

    public Message(int id, int date, int out, int userId, int fromId, int readState, String body) {
        mId = id;
        mDate = date;
        mOut = out;
        mUserId = userId;
        mReadState = readState;
        mFromId = fromId;
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

    public int getFromId() {
        return mFromId;
    }

    public void setFromId(int fromId) {
        this.mFromId = fromId;
    }
}
