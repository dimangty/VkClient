package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class Videos implements Serializable {

    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<Video> mItems;

    public Videos(int count, ArrayList<Video> items) {
        mItems = items;
        mCount = count;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public ArrayList<Video> getItems() {
        return mItems;
    }

    public void setItems(ArrayList<Video> items) {
        this.mItems = items;
    }
}
