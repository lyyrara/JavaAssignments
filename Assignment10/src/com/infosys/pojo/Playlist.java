package com.infosys.pojo;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private String name;
	private List<Song> songs;
	private List<Podcast> podcasts;
    
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.podcasts = new ArrayList<>();
    }

    public Playlist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    @Override
    public String toString() {
        return "Playlist [name=" + name + ", songs=" + songs + ", podcasts=" + podcasts + "]";
    }
    
    
}