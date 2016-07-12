package com.example.dima.vkclient.ui;

import android.app.Activity;
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

import com.example.dima.vkclient.adapters.DialogsAdapter;
import com.example.dima.vkclient.model.Dialog;
import com.example.dima.vkclient.model.DialogMessage;
import com.example.dima.vkclient.model.DialogResponse;
import com.example.dima.vkclient.model.Message;
import com.example.dima.vkclient.model.User;
import com.example.dima.vkclient.model.UserResponse;
import com.example.dima.vkclient.network.RetrofitService;
import com.example.dima.vkclient.network.VkApi;
import com.example.dima.vkclient.utils.OnDialogSelected;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dima on 10.07.16.
 */
public class DialogsFragment extends Fragment {

    private Context mContext;
    private String userId, token;
    private OnDialogSelected mDialogListener;

    @BindView(R.id.dialog_fragment_listView_dialogs)
    ListView mDialogList;
    private DialogResponse mDialogs;
    private UserResponse mUsers;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mDialogListener = (OnDialogSelected) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogs_fragment, null);
        ButterKnife.bind(this, view);

        mContext = container.getContext();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userId = bundle.getString("id");
            token = bundle.getString("token");
        }

        loadDialogs();
        return view;
    }

    void loadDialogs() {
        VkApi vkApi = RetrofitService.getInstance(mContext).createApiService(VkApi.class);
        Call<DialogResponse> call = vkApi.getDialogs(token, "5.52");

        call.enqueue(new Callback<DialogResponse>() {
            @Override
            public void onResponse(Call<DialogResponse> call, Response<DialogResponse> response) {
                mDialogs = response.body();
                String ids = mDialogs.getUserIds();
                loadUsers(ids);

            }

            @Override
            public void onFailure(Call<DialogResponse> call, Throwable t) {
                int i=0;
                i++;
            }


        });
    }

    void loadUsers(String ids) {
        VkApi vkApi = RetrofitService.getInstance(mContext).createApiService(VkApi.class);
        Call<UserResponse> call = vkApi.getUsers(ids, "city,domain,photo_100,photo_50", "5.52");

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                mUsers = response.body();
                int index = 0;

                for (User user : mUsers.getUsers()) {
                    DialogMessage message = mDialogs.getDialogs().getItems().get(index).getMessage();
                    message.setUser(user);
                    index++;
                }


                loadTable();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }


        });
    }

    void loadTable() {

        // создаем адаптер
        DialogsAdapter adapter = new DialogsAdapter(mContext, mDialogs.getDialogs().getItems());
        mDialogList.setAdapter(adapter);


        mDialogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Dialog dialog = mDialogs.getDialogs().getItems().get(position);
                mDialogListener.OnDialogSelect(dialog.getMessage().getUserId());
            }
        });

    }
}
