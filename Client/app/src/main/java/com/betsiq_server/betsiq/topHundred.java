package com.betsiq_server.betsiq;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.betsiq_server.betsiq.Adapters.topSongAdapter;
import com.betsiq_server.betsiq.CoreClasses.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class topHundred extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tophundred, container, false);

        ListView topSongs = (ListView)view.findViewById(R.id.songs);

        List<Song> Songs =  new ArrayList<Song>();
        Songs.add(new Song(1, "Song 1", "Artist 1"));
        Songs.add(new Song(2, "Song 2", "Artist 2"));
        Songs.add(new Song(3, "Song 3", "Artist 3"));

        topSongAdapter adapter = new topSongAdapter(getActivity(), Songs);
        topSongs.setAdapter(adapter);
        return view;
    }
}
