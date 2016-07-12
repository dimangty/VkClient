package com.example.dima.vkclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.model.Dialog;
import com.example.dima.vkclient.model.DialogMessage;
import com.example.dima.vkclient.model.Message;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dima on 10.07.16.
 */
public class DialogsAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater lInflater;
    ArrayList<Dialog> objects;
    String tag = "MyLogs";

    public DialogsAdapter(Context context, ArrayList<Dialog> categories) {
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
            vh = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.dialog_item, parent, false));
            vh.root.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Dialog dialogItem = getDialog(position);
        DialogMessage message = dialogItem.getMessage();
        String userName = message.getUser().getLastName() + " " + message.getUser().getFirstName();
        vh.userNameTextView.setText(userName);
        vh.messageTextView.setText(message.getBody());
        Picasso.with(mContext).load(message.getUser().getPhoto100()).resize(100, 100).onlyScaleDown().error(R.drawable.avatar).into(vh.userImageView);


        return vh.root;
    }

    Dialog getDialog(int position) {
        return ((Dialog) getItem(position));
    }

    private static class ViewHolder {
        TextView userNameTextView;
        ImageView userImageView;
        TextView messageTextView;

        View root;

        public ViewHolder(View rootView) {
            root = rootView;
            userNameTextView = (TextView) rootView.findViewById(R.id.dialogItem_textView_Name);
            userImageView = (ImageView) rootView.findViewById(R.id.dialogItem_imageView_avatar);
            messageTextView = (TextView) rootView.findViewById(R.id.dialogItem_textView_message);


        }

    }
}
