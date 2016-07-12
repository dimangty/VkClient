package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 * id: 189157344,
 * owner_id: -37273781,
 * artist: 'Fr&#233;d&#233;ric Fran&#231;ois Chopin',
 * title: 'Nocturne Op. 9 №1',
 * duration: 327,
 * date: 1360439875,
 * url: 'https://psv4.vk.m...kHQxFT_rfaSsN8B1Hv3',
 * lyrics_id: 4427560,
 * genre_id: 18
 */
public class Audio implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("owner_id")
    private int mOwnerId;

    @SerializedName("artist")
    private String mArtist;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("duration")
    private int mDuration;

    @SerializedName("date")
    private int mDate;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("lyrics_id")
    private int mLyricsId;

    @SerializedName("genre_id")
    private int mGenreId;

    public Audio(int id, int ownerId, String artist, String title, int duration, int date, String url, int lyricsId, int genreId) {
        mId = id;
        mOwnerId = ownerId;
        mArtist = artist;
        mTitle = title;
        mDuration = duration;
        mDate = date;
        mUrl = url;
        mLyricsId = lyricsId;
        mGenreId = genreId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(int ownerId) {
        this.mOwnerId = ownerId;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
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

    public int getDate() {
        return mDate;
    }

    public void setDate(int date) {
        this.mDate = date;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public int getLyricsId() {
        return mLyricsId;
    }

    public void setLyricsId(int lyricsId) {
        this.mLyricsId = lyricsId;
    }

    public int getGenreId() {
        return mGenreId;
    }

    public void setGenreId(int genreId) {
        this.mGenreId = genreId;
    }


}
