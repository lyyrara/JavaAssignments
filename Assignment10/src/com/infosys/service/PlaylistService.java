package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.pojo.Playlist;
import com.infosys.pojo.Podcast;
import com.infosys.pojo.Song;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlaylistService {
    private PlaylistDao playlistDao;
    private Scanner sc;
    


    public PlaylistService() {
        this.playlistDao = new PlaylistDao();
        this.sc = new Scanner(System.in);
    }

    public void addPlaylist() {
        System.out.print("Enter a playlist's name: ");
        String name = sc.nextLine();
        Playlist playlist = new Playlist(name);
        boolean added = playlistDao.addPlaylist(playlist); 
        if (added) {
            System.out.println("Playlist added successfully.");
        } else {
            System.out.println("Playlist not added.");
        } 
	}


    public void removePodcast() {
        System.out.print("Enter the playlist's name to remove: ");
        String name = sc.nextLine();
        boolean removed = playlistDao.removePlaylist(name);
        if (removed) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void addSongToPlaylist() {
        System.out.println("Please choose a song's name to playlist:");
        System.out.println("Enter the playlist's name:");
        String playlist_name = sc.nextLine(); 
        System.out.print("Enter a song's name: ");
        String name = sc.nextLine();
        System.out.print("Enter a song's artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter a song's genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter a album name: ");
        String album_name = sc.nextLine();
        Song song = new Song(name, artist, genre, album_name);
        boolean isAdded = playlistDao.addSongToPlaylist(song, playlist_name);

        if (isAdded) {
            System.out.println("Song added to playlist successfully.");
        } else {
            System.out.println("Failed to add song to playlist. Playlist may not exist.");
        }
    }

    public void addPodcastToPlaylist() {
        System.out.println("Please choose a song's name to playlist:");
        System.out.println("Enter the playlist's name:");
        String playlist_name = sc.nextLine(); 
        System.out.print("Enter a podcast's title: ");
        String title = sc.nextLine();
        System.out.print("Enter a podcast's celebrity: ");
        String celebrity = sc.nextLine();
        System.out.print("Enter a podcast's pubDate: ");
        String pubDate = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(pubDate, formatter);
        Podcast podcast = new Podcast(title, celebrity, localDate);
        boolean isAdded = playlistDao.addPodcastToPlaylist(podcast, playlist_name);

        if (isAdded) {
            System.out.println("Podcast added to playlist successfully.");
        } else {
            System.out.println("Failed to add Podcast to playlist. Playlist may not exist.");
        }
    }

    public void addPlaylistByCategory() {
        System.out.println("Please choose playlist's category to add: 1.song 2.podcast");
        int option = sc.nextInt();
        sc.nextLine();
        List<Podcast> results = new ArrayList<>();
        switch (option) {
            case 1:
                addSongToPlaylist();
                break;
            case 2:
                addPodcastToPlaylist();
                break;
            default:
                throw new AssertionError();
        }
        displayPlaylistByName(); 
        
    }

    public void displayAllPlaylist() {
        List<Playlist> playlists = playlistDao.getAllPlaylists();
        for (Playlist playlist  : playlists) {
            System.out.println(playlist.toString());
        }   
    }

    public void displayPlaylistByName() {
        System.out.println("Enter the playlist's name:");
        String playlist_name = sc.nextLine(); 
        Playlist playlist = playlistDao.getPlaylistByName(playlist_name);
        System.out.println(playlist.toString());
         
    }
    

    
}

