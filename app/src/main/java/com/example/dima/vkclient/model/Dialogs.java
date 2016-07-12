package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class Dialogs implements Serializable {
    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<Dialog> mItems;

    public Dialogs(int count, ArrayList<Dialog> items) {
        mCount = count;
        mItems = items;
    }

    public int getCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public ArrayList<Dialog> getItems() {
        return mItems;
    }

    public void setItems(ArrayList<Dialog> items) {
        mItems = items;
    }
}
