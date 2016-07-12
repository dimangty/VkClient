package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 11.07.16.
 */
public class SendResponse implements Serializable {
    @SerializedName("response")
    private int response;
}
