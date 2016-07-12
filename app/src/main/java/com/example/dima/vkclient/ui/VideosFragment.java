package com.example.dima.vkclient.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.adapters.VideoAdapter;
import com.example.dima.vkclient.model.Video;
import com.example.dima.vkclient.model.VideoResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;
import com.example.dima.vkclient.utils.OnVideoSelected;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dima on 10.07.16.
 */
public class VideosFragment extends Fragment {
    private Context mContext;
    String userId, token;


    @BindView(R.id.video_fragment_listView_videos)
    ListView mVideoList;

    private VideoResponse mVideoResponse;
    private OnVideoSelected mVideoListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mVideoListener = (OnVideoSelected) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, null);
        ButterKnife.bind(this, view);

        mContext = container.getContext();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userId = bundle.getString("id");
            token = bundle.getString("token");
        }

        loadVideos();
        return view;
    }

    void loadVideos() {
        VkApi vkApi = RetrofitService.getInstance(mContext).createApiService(VkApi.class);
        Call<VideoResponse> call = vkApi.getVideo(userId, token, "0", "5.52");

        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                mVideoResponse = response.body();
                loadVideoTable();
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {
                int i = 0;
                i++;
            }


        });
    }

    void loadVideoTable()
    {
        // создаем адаптер
        VideoAdapter adapter = new VideoAdapter(mContext, mVideoResponse.getVideos().getItems());
        mVideoList.setAdapter(adapter);


        mVideoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Video video = mVideoResponse.getVideos().getItems().get(position);
                mVideoListener.OnVideoSelect(video.getPlayer());
            }
        });
    }

}
