package com.example.dima.vkclient.network;

import android.content.Context;

import com.example.dima.vkclient.R;

/**
 * Created by dima on 08.07.16.
 */
public class VkApiUrls {
    static final String API = "/method";

    public static class VkUrl {

        public static final String GET_AUDIO = API + "/audio.get?";
        public static final String GET_DIALOGS = API + "/messages.getDialogs?";
        public static final String GET_FRIENDS = API + "/friends.get?";
        public static final String GET_MESSAGES = API + "/messages.getHistory?";
        public static final String GET_USERS = API + "/users.get?";
        public static final String GET_VIDEO = API + "/video.get?";
        public static final String SEND_MESSAGES = API + "/messages.send?";
    }

    public static String getVkApiBaseUrl(Context context)
    {
        return "https://api.vk.com/";
    }
}
