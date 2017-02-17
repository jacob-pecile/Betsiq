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
import com.betsiq_server.betsiq.CoreClasses.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class topHundred extends MenuActivity{

    private topSongAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tophundred);

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_hundred);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);

        ListView topSongs = (ListView)findViewById(R.id.songs);

        String user = Constants.GetSharedPrefrences(getApplicationContext(), getResources().getString(R.string.USER));

        List<Song> Songs =  new ArrayList<Song>();
        Songs.add(new Song(1, "Song 1", "Artist 1"));
        Songs.add(new Song(2, "Song 2", "Artist 2"));
        Songs.add(new Song(3, "Song 3", "Artist 3"));

        _adapter = new topSongAdapter(this, Songs);
        topSongs.setAdapter(_adapter);
    }

    public void makeToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void SaveChoices(View v){
        _adapter.getSelectedSongs();
        //TODO: POST selected songs

        makeToast("Selected songs saved");
    }
}
