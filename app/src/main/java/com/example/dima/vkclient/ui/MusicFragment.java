package com.example.dima.vkclient.ui;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.adapters.MusicAdapter;
import com.example.dima.vkclient.model.Audio;
import com.example.dima.vkclient.model.AudioResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;
import com.example.dima.vkclient.utils.OnCustomClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dima on 10.07.16.
 */
public class MusicFragment extends Fragment implements OnCustomClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    private Context mContext;
    private String userId, token;
    private String tag = "MyLogs";

    @BindView(R.id.music_fragment_listView_tracks)
    ListView mAudioList;

    private AudioResponse mAudioResponse;
    private MusicAdapter mAdapter;
    private MediaPlayer mMediaPlayer;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_fragment, null);
        ButterKnife.bind(this, view);

        mContext = container.getContext();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userId = bundle.getString("id");
            token = bundle.getString("token");
        }

        loadMusic();
        return view;
    }



    void loadMusic() {
        VkApi vkApi = RetrofitService.getInstance(mContext).createApiService(VkApi.class);
        Call<AudioResponse> call = vkApi.getAudio(userId, token, "0", "5.52");

        call.enqueue(new Callback<AudioResponse>() {
            @Override
            public void onResponse(Call<AudioResponse> call, Response<AudioResponse> response) {
                mAudioResponse = response.body();
                loadAudioTable();
            }

            @Override
            public void onFailure(Call<AudioResponse> call, Throwable t) {
                int i = 0;
                i++;
            }


        });
    }

    void loadAudioTable() {
        // создаем адаптер
        if (mAdapter == null)
            mAdapter = new MusicAdapter(mContext, mAudioResponse.getAudios().getItems(), this);

        mAudioList.setAdapter(mAdapter);

    }


    private void releaseMP() {
        if (mMediaPlayer != null) {
            try {
                mMediaPlayer.release();
                mMediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void OnCustomClick(View aView, int position) {

        releaseMP();

        if (mAdapter.getLastPosition() == position) {
            mAdapter.setLastPosition(-1);
            return;
        }
        mAdapter.setLastPosition(position);

        Audio audio = (Audio) mAudioResponse.getAudios().getItems().get(position);

        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(audio.getUrl());
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setOnCompletionListener(this);

            mMediaPlayer.prepareAsync();
            //
        } catch (Exception e) {

        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(tag, "onPrepared");
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.d(tag, "onCompletion");
    }


}
