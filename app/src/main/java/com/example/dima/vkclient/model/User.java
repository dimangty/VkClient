package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 08.07.16.
 */
public class User implements Serializable {
    @SerializedName("id")
    private int mId;

    @SerializedName("first_name")
    private String mFirstName;

    @SerializedName("last_name")
    private String mLastName;

    @SerializedName("domain")
    private String mDomain;

    @SerializedName("city")
    private City mCity;

    @SerializedName("online")
    private int mOnline;

    @SerializedName("photo_50")
    private String mPhoto50;

    @SerializedName("photo_100")
    private String mPhoto100;


    public User(int id, String firstName, String lastName, String domain, City city, int online, String photo50, String photo100) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mDomain = domain;
        mCity = city;
        mOnline = online;
        mPhoto50 = photo50;
        mPhoto100 = photo100;
    }

    public int getOnline() {
        return mOnline;
    }

    public void setOnline(int online) {
        this.mOnline = online;
    }


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getDomain() {
        return mDomain;
    }

    public void setDomain(String domain) {
        this.mDomain = domain;
    }

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        this.mCity = city;
    }

    public String getPhoto100() {
        return mPhoto100;
    }

    public void setPhoto100(String photo100) {
        this.mPhoto100 = photo100;
    }

    public String getPhoto50() {
        return mPhoto50;
    }

    public void setPhoto50(String photo50) {
        this.mPhoto50 = photo50;
    }
}
