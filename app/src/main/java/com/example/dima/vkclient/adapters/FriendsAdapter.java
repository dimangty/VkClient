package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.User;

/**
 * Created by dima on 09.07.16.
 */
public class FriendsAdapter extends CollectionRecycleAdapter<User> {
    public FriendsAdapter(Context context) {
        super(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FriendsViewHolder(mInflater.inflate(R.layout.friend_item, parent, false));
    }
}
