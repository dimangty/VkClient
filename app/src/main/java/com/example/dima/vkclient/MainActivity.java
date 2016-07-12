package com.example.dima.vkclient;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dima.vkclient.model.Friends;
import com.example.dima.vkclient.model.FriendsResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;
import com.example.dima.vkclient.ui.MenuActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private final int appid = 3660539;
    final String LOG_TAG = "Login log";
    String token, userId;
    private Call mRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar


        setContentView(R.layout.activity_main);


        mWebView = (WebView) findViewById(R.id.main_webView);
        loadLoginWindow();
    }

    void loadLoginWindow() {

        // int appid=3660539;// 3692458;
        String url = "http://api.vk.com/oauth/authorize?client_id=" + appid + "&scope=wall,audio,video,messages&redirect_uri=http://api.vk.com/blank.html&display=touch&response_type=token";

        Uri data = Uri.parse(url);
        mWebView.loadUrl(data.toString());
        WebViewClient client = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.d(LOG_TAG, "WebStart");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(LOG_TAG, "WebFinish");
                Log.d(LOG_TAG, "Url=" + view.getUrl());
                if (url.contains("access_token")) {
                    token = getToken(url);
                    userId = getUserId(url);

                    Log.d(LOG_TAG, "Token=" + token);
                    Log.d(LOG_TAG, "User=" + userId);


                    showSecondActivity();
                }
            }
        };

        mWebView.setWebViewClient(client);
    }

    void showSecondActivity() {

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("id", userId);
        intent.putExtra("token", token);
        startActivity(intent);

//        VkApi vkApi = RetrofitService.getInstance(this).createApiService(VkApi.class);
//        Call<FriendsResponse> call = vkApi.getFriends2(userId,"city,domain","5.52");
//
//        call.enqueue(new Callback<FriendsResponse>() {
//            @Override
//            public void onResponse(Call<FriendsResponse> call, Response<FriendsResponse> response) {
//                int i=0;
//                FriendsResponse friends = response.body();
//                i++;
//            }
//
//            @Override
//            public void onFailure(Call<FriendsResponse> call, Throwable t) {
//
//            }
//
//
//        });

    }

    String getToken(String URL) {
        String bufUrl = URL;
        bufUrl = bufUrl.substring(URL.indexOf("access_token"));
        bufUrl = bufUrl.substring(bufUrl.indexOf("=") + 1);
        bufUrl = bufUrl.substring(0, bufUrl.indexOf("&"));
        return bufUrl;
    }

    String getUserId(String URL) {
        String bufUrl = URL;
        String[] strs = bufUrl.split("=");
        String userId = strs[strs.length - 1];
        return userId;
    }
}
