package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 */
public class Dialog implements Serializable {
    @SerializedName("message")
    private DialogMessage mMessage;

    @SerializedName("in_read")
    private int mInRead;

    @SerializedName("out_read")
    private int mOutRead;

    public Dialog(DialogMessage message, int inRead, int outRead) {
        mMessage = message;
        mInRead = inRead;
        mOutRead = outRead;
    }

    public DialogMessage getMessage() {
        return mMessage;
    }

    public void setMessage(DialogMessage message) {
        this.mMessage = message;
    }


    public int getInRead() {
        return mInRead;
    }

    public void setInRead(int inRead) {
        this.mInRead = inRead;
    }

    public int getOutRead() {
        return mOutRead;
    }

    public void setOutRead(int outRead) {
        this.mOutRead = outRead;
    }
}