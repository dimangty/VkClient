package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.Audio;
import com.example.dima.vkclient.utils.CustomOnClickListener;
import com.example.dima.vkclient.utils.OnCustomClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class MusicAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater lInflater;
    ArrayList<Audio> objects;
    String tag = "MyLogs";
    private OnCustomClickListener mCallback;
    private int mLastPosition;


    public MusicAdapter(Context context, ArrayList<Audio> audios, OnCustomClickListener callback) {
        mContext = context;
        objects = audios;
        mCallback = callback;
        lInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLastPosition = -1;
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
            vh = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false));
            vh.root.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Audio audioItem = getAudio(position);
        vh.musicNameTextView.setText(audioItem.getArtist() + "-" + audioItem.getTitle());

        ImageButton btn = vh.playBtn;
        btn.setOnClickListener(new CustomOnClickListener(mCallback, position));
        if (mLastPosition == position)
            btn.setImageResource(R.drawable.ic_pause);
        else
            btn.setImageResource(R.drawable.ic_play);


        return vh.root;
    }

    String convertTime(int time) {
        int min = (time - time % 60) / 60;
        int sec = time % 60;
        String result = "" + min + ":" + sec;
        return result;
    }

    Audio getAudio(int position) {
        return ((Audio) getItem(position));
    }

    public int getLastPosition() {
        return mLastPosition;
    }

    public void setLastPosition(int lastPosition) {
        mLastPosition = lastPosition;
        notifyDataSetChanged();
    }


    private static class ViewHolder {
        TextView musicNameTextView;
        ImageButton playBtn;


        View root;

        public ViewHolder(View rootView) {
            root = rootView;
            musicNameTextView = (TextView) rootView.findViewById(R.id.musicItem_textView_song);
            playBtn = (ImageButton) rootView.findViewById(R.id.musicItem_imageButton_play);
        }

    }


}