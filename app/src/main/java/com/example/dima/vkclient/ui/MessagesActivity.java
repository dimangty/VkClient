package com.example.dima.vkclient.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.adapters.MessageAdapter;

import com.example.dima.vkclient.model.Message;
import com.example.dima.vkclient.model.MessagesResponse;
import com.example.dima.vkclient.model.SendResponse;
import com.example.dima.vkclient.model.User;
import com.example.dima.vkclient.model.UserResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dima on 11.07.16.
 */
public class MessagesActivity extends AppCompatActivity {

    private String userId, token, dialogUserId;
    private MessagesResponse mMessageResponse;
    private UserResponse mUsers;

    @BindView(R.id.messages_activity_listView_history)
    ListView mHistoryList;

    @BindView(R.id.messages_activity_editText_message)
    EditText mMessageEditText;

    @BindView(R.id.messages_activity_imageButton_send)
    ImageButton mSendButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_activity);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userId = intent.getStringExtra("id");
        dialogUserId = intent.getStringExtra("dialogUserId");
        token = intent.getStringExtra("token");

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        loadMessageHistory();
    }


    void loadMessageHistory() {
        VkApi vkApi = RetrofitService.getInstance(this).createApiService(VkApi.class);
        Call<MessagesResponse> call = vkApi.getMessagesHistory(dialogUserId, "100", token, "5.52");

        call.enqueue(new Callback<MessagesResponse>() {
            @Override
            public void onResponse(Call<MessagesResponse> call, Response<MessagesResponse> response) {
                mMessageResponse = response.body();
                String ids = userId + "," + dialogUserId;
                loadUsers(ids);

            }

            @Override
            public void onFailure(Call<MessagesResponse> call, Throwable t) {
                int i = 0;
                i++;
            }


        });
    }

    void loadUsers(String ids) {
        VkApi vkApi = RetrofitService.getInstance(this).createApiService(VkApi.class);
        Call<UserResponse> call = vkApi.getUsers(ids, "city,domain,photo_100,photo_50", "5.52");

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                mUsers = response.body();

                for (Message message : mMessageResponse.getMessages().getItems()) {
                    User user;
                    if (message.getOut() == 1)
                        user = mUsers.getUsers().get(0);
                    else
                        user = mUsers.getUsers().get(1);

                    message.setUser(user);

                }


                loadTable();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }


        });
    }

    void loadTable() {
        MessageAdapter adapter = new MessageAdapter(this, mMessageResponse.getMessages().getItems());
        mHistoryList.setAdapter(adapter);
    }


    void sendMessage() {
        String sendString = convertToQuotedPrintable(mMessageEditText.getEditableText().toString());

        VkApi vkApi = RetrofitService.getInstance(this).createApiService(VkApi.class);
        Call<SendResponse> call = vkApi.sendMessage(dialogUserId, sendString, token, "5.52");

        call.enqueue(new Callback<SendResponse>() {
            @Override
            public void onResponse(Call<SendResponse> call, Response<SendResponse> response) {
                loadMessageHistory();
            }

            @Override
            public void onFailure(Call<SendResponse> call, Throwable t) {
                String error = "Error";

            }


        });
    }

    String convertToQuotedPrintable(String original) {


        String result = "";
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            int left = ~c & 0x0f;
            int right = ~(c >> 4) & 0x0f;

            result = result + "%" + Integer.toHexString(right) + Integer.toHexString(left);
        }

        //return result;
        return original;
    }
}
