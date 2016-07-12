package com.example.dima.vkclient.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.adapters.FriendsAdapter;
import com.example.dima.vkclient.model.FriendsResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dima on 09.07.16.
 */
public class FriendsFragment extends Fragment {

    private Context mContext;
    String userId, token;

    private FriendsResponse mFriends;
    private FriendsAdapter mFriendAdapter;

    @BindView(R.id.friendRecycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.friends_fragment_button_list)
    ImageButton mListButton;

    @BindView(R.id.friends_fragment_button_grid)
    ImageButton mGridButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment, null);
        ButterKnife.bind(this, view);

        mContext = container.getContext();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userId = bundle.getString("id");
            token = bundle.getString("token");
        }


        FriendsAdapter friendsAdapter = new FriendsAdapter(mContext);
        mFriendAdapter = friendsAdapter;
        mRecyclerView.setAdapter(friendsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        mListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            }
        });

        mGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
            }
        });


        loadFriends();
        return view;
    }


    void loadFriends() {
        VkApi vkApi = RetrofitService.getInstance(mContext).createApiService(VkApi.class);
        Call<FriendsResponse> call = vkApi.getFriends(userId, "city,domain,photo_100", "5.52");

        call.enqueue(new Callback<FriendsResponse>() {
            @Override
            public void onResponse(Call<FriendsResponse> call, Response<FriendsResponse> response) {
                mFriends = response.body();
                mFriendAdapter.setCollection(mFriends.getFriends().getUsers());


            }

            @Override
            public void onFailure(Call<FriendsResponse> call, Throwable t) {

            }


        });
    }
}
