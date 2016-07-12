package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.Message;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dima on 11.07.16.
 */
public class MessageAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater lInflater;
    ArrayList<Message> objects;
    String tag = "MyLogs";

    public MessageAdapter(Context context, ArrayList<Message> categories) {
        mContext = context;
        objects = categories;

        lInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item, parent, false));
            vh.root.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

      //  Message message = getMessage(objects.size() - 1 - position);
        Message message = getMessage(position);


        vh.messageTextView.setText(message.getBody());

        if (message.getOut() == 0) {
            vh.otherUserImageView.setVisibility(View.VISIBLE);
            vh.userImageView.setVisibility(View.GONE);

            Picasso.with(mContext).load(message.getUser().getPhoto100()).resize(100, 100).onlyScaleDown().error(R.drawable.avatar).into(vh.otherUserImageView);
        } else {
            vh.otherUserImageView.setVisibility(View.GONE);
            vh.userImageView.setVisibility(View.VISIBLE);

            Picasso.with(mContext).load(message.getUser().getPhoto100()).resize(100, 100).onlyScaleDown().error(R.drawable.avatar).into(vh.userImageView);
        }

        return vh.root;
    }

    Message getMessage(int position) {
        return ((Message) getItem(position));
    }

    private static class ViewHolder {

        ImageView userImageView;
        ImageView otherUserImageView;
        TextView messageTextView;

        View root;

        public ViewHolder(View rootView) {
            root = rootView;

            userImageView = (ImageView) rootView.findViewById(R.id.messageItem_imageView_outAvatar);
            otherUserImageView = (ImageView) rootView.findViewById(R.id.messageItem_imageView_inAvatar);

            messageTextView = (TextView) rootView.findViewById(R.id.messageItem_textView_message);


        }

    }
}
