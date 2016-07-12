package com.example.dima.vkclient.network;

import com.example.dima.vkclient.model.AudioResponse;
import com.example.dima.vkclient.model.DialogResponse;
import com.example.dima.vkclient.model.Friends;
import com.example.dima.vkclient.model.FriendsResponse;
import com.example.dima.vkclient.model.MessagesResponse;
import com.example.dima.vkclient.model.SendResponse;
import com.example.dima.vkclient.model.UserResponse;
import com.example.dima.vkclient.model.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dima on 08.07.16.
 */
public interface VkApi {

    @GET(VkApiUrls.VkUrl.GET_AUDIO)
    Call<AudioResponse> getAudio(@Query("owner_id") String owner_id, @Query("access_token") String token, @Query("offset") String offset, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.GET_DIALOGS)
    Call<DialogResponse> getDialogs(@Query("access_token") String token, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.GET_MESSAGES)
    Call<MessagesResponse> getMessagesHistory(@Query("user_id") String userId, @Query("count") String count, @Query("access_token") String token, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.SEND_MESSAGES)
    Call<SendResponse> sendMessage(@Query("user_id") String userId, @Query("message") String message, @Query("access_token") String token, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.GET_USERS)
    Call<UserResponse> getUsers(@Query("user_ids") String user_ids, @Query("fields") String fields, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.GET_VIDEO)
    Call<VideoResponse> getVideo(@Query("owner_id") String owner_id, @Query("access_token") String token, @Query("offset") String offset, @Query("v") String v);

    @GET(VkApiUrls.VkUrl.GET_FRIENDS)
    Call<FriendsResponse> getFriends(@Query("user_id") String userId, @Query("fields") String fields, @Query("v") String v);

}
