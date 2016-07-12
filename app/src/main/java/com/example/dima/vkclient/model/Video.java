package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 */
public class Video implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("owner_id")
    private int mOwnderId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("duration")
    private int mDuration;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("date")
    private int mDate;

    @SerializedName("views")
    private int mViews;

    @SerializedName("comments")
    private int mComments;

    @SerializedName("photo_130")
    private String mPhoto130;

    @SerializedName("photo_320")
    private String mPhoto320;

    @SerializedName("photo_800")
    private String mPhoto800;

    @SerializedName("adding_date")
    private int mAddingDate;

    @SerializedName("player")
    private String mPlayer;

    @SerializedName("can_add")
    private int mCanAdd;

    public Video(int id, int ownderId, String title, int duration, String description, int date, int views, int comments, String photo130, String photo320, String photo800, int addingDate, String player, int canAdd) {
        mId = id;
        mOwnderId = ownderId;
        mTitle = title;
        mDuration = duration;
        mDescription = description;
        mDate = date;
        mViews = views;
        mComments = comments;
        mPhoto130 = photo130;
        mPhoto320 = photo320;
        mPhoto800 = photo800;
        mAddingDate = addingDate;
        mPlayer = player;
        mCanAdd = canAdd;
    }


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getOwnderId() {
        return mOwnderId;
    }

    public void setOwnderId(int ownderId) {
        this.mOwnderId = ownderId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getDate() {
        return mDate;
    }

    public void setDate(int date) {
        this.mDate = date;
    }

    public int getViews() {
        return mViews;
    }

    public void setViews(int views) {
        this.mViews = views;
    }

    public int getComments() {
        return mComments;
    }

    public void setComments(int comments) {
        this.mComments = comments;
    }

    public String getPhoto130() {
        return mPhoto130;
    }

    public void setPhoto130(String photo130) {
        this.mPhoto130 = photo130;
    }

    public String getPhoto320() {
        return mPhoto320;
    }

    public void setPhoto320(String photo320) {
        this.mPhoto320 = photo320;
    }

    public String getPhoto800() {
        return mPhoto800;
    }

    public void setPhoto800(String photo800) {
        this.mPhoto800 = photo800;
    }

    public int getAddingDate() {
        return mAddingDate;
    }

    public void setAddingDate(int addingDate) {
        this.mAddingDate = addingDate;
    }

    public String getPlayer() {
        return mPlayer;
    }

    public void setPlayer(String player) {
        this.mPlayer = player;
    }

    public int getCanAdd() {
        return mCanAdd;
    }

    public void setCanAdd(int canAdd) {
        this.mCanAdd = canAdd;
    }
}
