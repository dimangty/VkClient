package com.example.dima.vkclient.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dima.vkclient.R;
import com.example.dima.vkclient.utils.OnDialogSelected;
import com.example.dima.vkclient.utils.OnVideoSelected;

/**
 * Created by dima on 09.07.16.
 */
public class MenuActivity extends AppCompatActivity implements OnDialogSelected, OnVideoSelected {
    private static String userId, token;
    private String tag = "MyLogs";
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;

    private ListView mDrawerListView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mCategories;
    private FragmentManager mFragmentManager;

    private FriendsFragment mFriendsFragment;
    private DialogsFragment mDialogsFragment;
    private MusicFragment mMusicFragment;
    private VideosFragment mVideosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        mFragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();
        if (userId == null)
            userId = intent.getStringExtra("id");

        if (token == null)
            token = intent.getStringExtra("token");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        mTitle = mDrawerTitle = getTitle();


        mCategories = new String[]{"Messages", "Music", "Video", "Friends"};

        mDrawerListView.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, R.id.drawer_textView, mCategories));

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        // Включаем значок у ActionBar для управления выдвижной панелью щелчком
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                null,  /* значок-гамбургер для замены стрелки 'Up' */
                R.string.drawer_open,  /* добавьте строку "open drawer" - описание для  accessibility */
                R.string.drawer_close  /* добавьте "close drawer" - описание для accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void selectItem(int position) {
        // Обновляем содержимое экрана, заменяя фрагменты
//        Fragment fragment = new CatFragment();
//        Bundle args = new Bundle();
//        args.putInt(CatFragment.ARG_CAT_NUMBER, position);
//        fragment.setArguments(args);
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        if (position == 0) {
            if (mDialogsFragment == null) {
                mDialogsFragment = new DialogsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", userId);
                bundle.putString("token", token);
                mDialogsFragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mDialogsFragment, "Dialogs tag");
            fragmentTransaction.addToBackStack("myStack");
            fragmentTransaction.commit();
        } else if (position == 1) {
            if (mMusicFragment == null) {
                mMusicFragment = new MusicFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", userId);
                bundle.putString("token", token);
                mMusicFragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mMusicFragment, "Music tag");
            fragmentTransaction.addToBackStack("myStack");
            fragmentTransaction.commit();
        } else if (position == 2) {
            if (mVideosFragment == null) {
                mVideosFragment = new VideosFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", userId);
                bundle.putString("token", token);
                mVideosFragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mVideosFragment, "Video tag");
            fragmentTransaction.addToBackStack("myStack");
            fragmentTransaction.commit();
        } else if (position == 3) {
            if (mFriendsFragment == null) {
                mFriendsFragment = new FriendsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", userId);
                bundle.putString("token", token);
                mFriendsFragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mFriendsFragment, "Friend tag");
            fragmentTransaction.addToBackStack("myStack");
            fragmentTransaction.commit();
        }

        // обновим выбранный элемент списка и закрываем панель
        mDrawerListView.setItemChecked(position, true);
        setTitle(mCategories[position]);
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(mTitle);
        } else {
            setTitle(mTitle);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    /* Called whenever we call invalidateOptionsMenu() */
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        // If the nav drawer is open, hide action items related to the content view
//        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerListView);
//        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
//        return super.onPrepareOptionsMenu(menu);
//    }
//


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void OnDialogSelect(int dialogId) {


        Intent intent = new Intent(this, MessagesActivity.class);
        intent.putExtra("id", userId);
        intent.putExtra("token", token);
        intent.putExtra("dialogUserId", "" + dialogId);
        startActivity(intent);
    }

    @Override
    public void OnVideoSelect(String playerUrl) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("video_url", playerUrl);

        startActivity(intent);
    }
}
