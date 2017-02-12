package com.betsiq_server.betsiq.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.betsiq_server.betsiq.CoreClasses.Song;
import com.betsiq_server.betsiq.R;
import com.betsiq_server.betsiq.topHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 27/01/2017.
 */

public class topSongAdapter extends BaseAdapter {

    private List<Song> Songs;
    private Activity Context;
    private static int numChecked = 0;

    public topSongAdapter(Activity context, List<Song> songs){
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

    public List<Song> getSelectedSongs(){
        List<Song> checkedSongs = new ArrayList<Song>();
        for (Song s : Songs){
            if (s.isSelected()){
                checkedSongs.add(s);
            }
        }
        return checkedSongs;
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

        CheckBox selected = (CheckBox) view.findViewById(R.id.selected);
        if (parent.getId() == R.id.songs) {
            final int pos = position;
            selected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectSong(v, pos);
                }
            });
        }else if (parent.getId() == R.id.my_songs){
            selected.setVisibility(View.GONE);
        }


        return view;
    }

    public void SelectSong(View view, int position) {
        CheckBox check = ((CheckBox)view);
        Song song = (Song)getItem(position);

        boolean checked = check.isChecked();
        numChecked = checked ? numChecked+1: numChecked-1;

        if (numChecked > 10){
            check.setChecked(false);
            song.setSelected(false);
            numChecked = 10;
            ((topHundred)Context).makeToast("You can only select 10 songs");
        }else{
            song.setSelected(checked);
        }

    }

}
