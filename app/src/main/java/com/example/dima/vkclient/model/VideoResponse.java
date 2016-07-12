package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 */
public class VideoResponse implements Serializable {
    @SerializedName("response")
    private Videos mVideos;

    public VideoResponse(Videos videos)
    {
        mVideos = videos;
    }

    public Videos getVideos() {
        return mVideos;
    }

    public void setVideos(Videos videos) {
        this.mVideos = videos;
    }
}
