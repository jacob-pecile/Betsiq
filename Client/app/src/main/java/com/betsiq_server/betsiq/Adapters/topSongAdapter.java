package com.betsiq_server.betsiq.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.betsiq_server.betsiq.CoreClasses.Song;
import com.betsiq_server.betsiq.R;

import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class topSongAdapter extends BaseAdapter {

    private List<Song> Songs;
    private Context Context;

    public topSongAdapter(Context context, List<Song> songs){
        this.Songs = songs;
        this.Context = context;
    }
    @Override
    public int getCount() {
        return Songs.size();
    }

    @Override
    public Object getItem(int position) {
        return Songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        // re-use an existing view, if one is available
        // otherwise create a new one
        if (view == null)
        {
            view = LayoutInflater.from(Context).inflate(R.layout.top_song, parent, false);
        }

        Song item = this.Songs.get(position);

        TextView rank = (TextView)view.findViewById(R.id.song_rank);
        rank.setText(Integer.toString(item.getRank()));
        TextView title = (TextView)view.findViewById(R.id.song_title);
        title.setText(item.getTitle());
        TextView artist = (TextView)view.findViewById(R.id.song_artist);
        artist.setText(item.getArtist());

        return view;
    }
}
