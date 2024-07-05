package com.infosys.pojo;

public class Song {
    private String name;
    private String artist;
    private String genre;
    private String album_name;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAlbum_name() {
        return album_name;
    }
    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }
    public Song(String name, String artist, String genre, String album_name) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.album_name = album_name;
    }
    
    
}
