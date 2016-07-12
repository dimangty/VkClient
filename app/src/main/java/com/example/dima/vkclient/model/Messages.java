package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 11.07.16.
 */
public class Messages implements Serializable {
    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<Message> mItems;

    @SerializedName("unread")
    private int mUnread;

    public Messages(int count, ArrayList<Message> items, int unread) {
        mCount = count;
        mItems = items;
        mUnread = unread;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }



    public int getUnread() {
        return mUnread;
    }

    public void setUnread(int unread) {
        this.mUnread = unread;
    }

    public ArrayList<Message> getItems() {
        return mItems;
    }

    public void setItems(ArrayList<Message> items) {
        this.mItems = items;
    }
}
