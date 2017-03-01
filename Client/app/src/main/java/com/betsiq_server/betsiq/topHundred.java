package com.betsiq_server.betsiq;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.betsiq_server.betsiq.Adapters.topSongAdapter;
import com.betsiq_server.betsiq.CoreClasses.Constants;
import com.betsiq_server.betsiq.CoreClasses.Song;
//import com.betsiq_server.betsiq.CoreClasses.User;
import com.betsiq_server.betsiq.CoreClasses.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.betsiq_server.betsiq.APIs.SongAPI.GetTopSongsAPI;
import static com.betsiq_server.betsiq.APIs.SongAPI.SelectSongsAPI;
import static com.betsiq_server.betsiq.APIs.UserAPI.ConfirmUserAPI;

/**
 * Created by Jacob on 27/01/2017.
 */

public class topHundred extends MenuActivity{

    private topSongAdapter _adapter;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tophundred);
        final String[] result = {""};

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_hundred);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);

        ListView topSongs = (ListView)findViewById(R.id.songs);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //GET top 100 songs
        Runnable getSongs = new Runnable() {
            @Override
            public void run() {
                try {
                    result[0] = GetTopSongsAPI(getApplicationContext());
                } catch (Exception ex) {
                    //handle error which cannot be thrown back
                }
            }
        };
        Thread top100 = new Thread(getSongs, "ServiceThread");
        top100.start();
        try {
            top100.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Song> Songs;
        try {
            Songs = mapper.readValue(result[0], new TypeReference<List<Song>>() {
            });
        } catch (IOException e){
            Songs = null;
        }
        _adapter = new topSongAdapter(this, Songs);
        topSongs.setAdapter(_adapter);
    }

    public void makeToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void SaveChoices(View v){
        final boolean[] result = {false};

        String user_str = Constants.GetSharedPrefrences(getApplicationContext(), getResources().getString(R.string.USER));
        try {
            User user = mapper.readValue(user_str, User.class);
            final String id = user.getId();

            final String songs = mapper.writeValueAsString(_adapter.getSelectedSongs());
            //TODO: POST selected songs
            Runnable postSongs = new Runnable() {
                @Override
                public void run() {
                    try {
                        result[0] = SelectSongsAPI(getApplicationContext(),songs ,id);
                    } catch (Exception ex) {
                        //handle error which cannot be thrown back
                    }
                }
            };
            Thread top100picks = new Thread(postSongs, "ServiceThread");
            top100picks.start();
            top100picks.join();
        }catch (Exception e){
            System.out.println(e);
        }

        makeToast("Selected songs saved");
    }
}
