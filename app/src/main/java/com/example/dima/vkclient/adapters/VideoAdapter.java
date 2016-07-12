package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class VideoAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater lInflater;
    ArrayList<Video> objects;
    String tag = "MyLogs";

    public VideoAdapter(Context context, ArrayList<Video> videos) {
        mContext = context;
        objects = videos;

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
            vh = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.video_item, parent, false));
            vh.root.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Video videoItem = getVideo(position);


        vh.videoNameTextView.setText(videoItem.getTitle());
        vh.videoTimeTextView.setText(convertTime(videoItem.getDuration()));
        Picasso.with(mContext).load(videoItem.getPhoto130()).resize(100, 100).onlyScaleDown().error(R.drawable.avatar).into(vh.videoImageView);


        return vh.root;
    }

    String convertTime(int time) {
        int min = (time - time % 60) / 60;
        int sec = time % 60;
        String result = "" + min + ":" + sec;
        return result;
    }

    Video getVideo(int position) {
        return ((Video) getItem(position));
    }

    private static class ViewHolder {
        TextView videoNameTextView;
        ImageView videoImageView;
        TextView videoTimeTextView;

        View root;

        public ViewHolder(View rootView) {
            root = rootView;
            videoNameTextView = (TextView) rootView.findViewById(R.id.videoItem_textView_Name);
            videoImageView = (ImageView) rootView.findViewById(R.id.videoItem_imageView_preview);
            videoTimeTextView = (TextView) rootView.findViewById(R.id.videoItem_textView_time);


        }

    }
}
