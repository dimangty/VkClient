package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 */
public class AudioResponse implements Serializable {
    @SerializedName("response")
    private Audios mAudios;


    public AudioResponse(Audios audios)
    {
        mAudios = audios;
    }


    public Audios getAudios() {
        return mAudios;
    }

    public void setAudios(Audios audios) {
        this.mAudios = audios;
    }
}
