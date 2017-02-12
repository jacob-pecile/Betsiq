package com.betsiq_server.betsiq;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.betsiq_server.betsiq.Adapters.topSongAdapter;
import com.betsiq_server.betsiq.CoreClasses.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class myList extends MenuActivity {

    private topSongAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylist);

        View footer = findViewById(R.id.footer);
        Button currentPage = (Button)footer.findViewById(R.id.menu_mylist);
        currentPage.setTextColor(Color.WHITE);
        currentPage.setEnabled(false);

        ListView topSongs = (ListView)findViewById(R.id.my_songs);

        //GET User's songs
        List<Song> songs= new ArrayList<Song>();
        Song song1 = new Song(1, "Song 1", "Artist 1");
        songs.add(song1);

        _adapter = new topSongAdapter(this, songs);
        topSongs.setAdapter(_adapter);
    }

}
