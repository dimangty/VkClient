package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class Audios implements Serializable {
    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<Audio> mItems;

    public Audios(int count, ArrayList<Audio> items)
    {
        mCount=count;
        mItems = items;
    }


    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public ArrayList<Audio> getItems() {
        return mItems;
    }

    public void setItems(ArrayList<Audio> items) {
        this.mItems = items;
    }
}
