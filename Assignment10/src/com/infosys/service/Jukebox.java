package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.pojo.Song;
import java.util.ArrayList;
import java.util.Optional;


public class Jukebox {
    private Catalog catalog;

    public Jukebox() {
        this.catalog = new Catalog();
    }

    public void addSong(String name, String artist, String genre, String albumName) {
        catalog.addSong(name, artist, genre, albumName);
    }

    public void removeSong(String name) {
        boolean removed = catalog.removeSong(name);
        if (removed) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void updateSong(String name, String artist, String genre, String albumName) {
        boolean updated = catalog.updateSong(name, artist, genre, albumName);
        if (updated) {
            System.out.println("Song updated successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void searchSong(String name) {
        Optional<Song> song = catalog.searchSong(name);
        song.ifPresent(s -> System.out.println("Found: " + s.getName()));
        song.orElseThrow(() -> new RuntimeException("Song not found"));
    }

    public ArrayList<Song> searchSongsByCategory(String genre) {
        return catalog.searchSongsByCategory(genre);
    }

    public void displaySongsByCategory(String genre) {
        ArrayList<Song> songs = catalog.searchSongsByCategory(genre);
        if (songs.isEmpty()) {
            System.out.println("No songs found for the genre: " + genre);
        } else {
            System.out.println("Songs in genre: " + genre);
            for (Song song : songs) {
                System.out.println("Name: " + song.getName() + ", Artist: " + song.getArtist() + ", Album: " + song.getAlbum_name());
            }
        }
    }

    public void displayAllSongs() {
        ArrayList<Song> allSongs = catalog.getAllSongs();
        if (allSongs.isEmpty()) {
            System.out.println("No songs in the catalog.");
        } else {
            System.out.println("All songs in the catalog:");
            for (Song song : allSongs) {
                System.out.println("Name: " + song.getName() + ", Artist: " + song.getArtist() + ", Genre: " + song.getGenre() + ", Album: " + song.getAlbum_name());
            }
        }
    }
}

