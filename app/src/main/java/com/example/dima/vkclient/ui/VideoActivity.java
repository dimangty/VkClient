package com.example.dima.vkclient.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dima.vkclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dima on 11.07.16.
 */
public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.video_activity_webView_player)
    WebView mPlayerWebView;

    private String mPlayerUrl;
    private String tag = "MyLogs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        ButterKnife.bind(this);

        WebSettings webSettings = mPlayerWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        Intent intent=getIntent();
        mPlayerUrl=intent.getStringExtra("video_url");

        loadVideo();
    }

    void loadVideo()
    {
        Uri data = Uri.parse(mPlayerUrl);
        mPlayerWebView.loadUrl(data.toString());
        WebViewClient client=new WebViewClient(){
            @Override
            public 	void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.d(tag, "WebStart");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(tag, "WebFinish");
                Log.d(tag,"Url="+view.getUrl());

            }
        };

        mPlayerWebView.setWebViewClient(client);
    }


}
