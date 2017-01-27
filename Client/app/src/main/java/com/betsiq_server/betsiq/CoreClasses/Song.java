package com.betsiq_server.betsiq.CoreClasses;

/**
 * Created by Jacob on 27/01/2017.
 */

public class Song {

    private int rank;
    private String title;
    private String artist;

    public Song (int rank, String title, String artist){
        this.rank = rank;
        this.title = title;
        this.artist = artist;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


}
