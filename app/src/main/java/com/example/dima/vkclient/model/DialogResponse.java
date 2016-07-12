package com.example.dima.vkclient.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dima on 10.07.16.
 */
public class DialogResponse implements Serializable {
    @SerializedName("response")
    private Dialogs mDialogs;

    public DialogResponse(Dialogs dialogs) {
        mDialogs = dialogs;

    }

    public Dialogs getDialogs() {
        return mDialogs;
    }

    public void setDialogs(Dialogs dialogs) {
        this.mDialogs = dialogs;
    }

    public String getUserIds() {
        String ids = "";
        for (Dialog dialog : mDialogs.getItems()) {
            DialogMessage message = dialog.getMessage();
            int userId = message.getUserId();
            ids = ids + userId + ",";
        }
        if(ids.length()>0)
            ids = ids.substring(0,ids.length()-1);
        return ids;
    }
}
