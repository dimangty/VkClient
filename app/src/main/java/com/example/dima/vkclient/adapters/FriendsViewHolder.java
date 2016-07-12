package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dima on 09.07.16.
 */
public class FriendsViewHolder extends CollectionRecycleAdapter.RecycleViewHolder<User> {

    @BindView(R.id.friendsItem_textView_fName)
    TextView mFirstNameTextView;

    @BindView(R.id.friendsItem_textView_lName)
    TextView mLastNameTextView;

    @BindView(R.id.friendsItem_imageView_avatar)
    ImageView mFriendAvatar;
    private Context mContext;


    public FriendsViewHolder(View rootView) {
        super(rootView);

    }

    @Override
    protected void create(View rootView) {
        ButterKnife.bind(this, rootView);
        mContext = rootView.getContext();
    }

    @Override
    public void bind(User model) {

        mFirstNameTextView.setText(model.getFirstName());
        mLastNameTextView.setText(model.getLastName());
        Picasso.with(mContext).load(model.getPhoto100()).resize(100, 100).onlyScaleDown().error(R.drawable.avatar).into(mFriendAvatar);


    }


}
