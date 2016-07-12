package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 11.07.16.
 */
public class MessagesResponse implements Serializable {
    @SerializedName("response")
    private Messages mMessages;


    public MessagesResponse(Messages messages)
    {
        mMessages = messages;
    }

    public Messages getMessages() {
        return mMessages;
    }

    public void setMessages(Messages messages) {
        this.mMessages = messages;
    }
}
