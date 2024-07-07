package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.pojo.Song;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class SongService {
    private SongDao songDao;
    private Scanner sc;


	

    public SongService() {
        this.songDao = new SongDao();
        this.sc = new Scanner(System.in);
    }

    public void addSong() {
        System.out.print("Enter a song's name: ");
        String name = sc.nextLine();
        System.out.print("Enter a song's artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter a song's genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter a album name: ");
        String album_name = sc.nextLine();
        songDao.addSong(name, artist, genre, album_name);
        
	}

    public void removeSong() {
        System.out.print("Enter the song's name to remove: ");
        String name = sc.nextLine();
        boolean removed = songDao.removeSong(name);
        if (removed) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void updateSong() {
        System.out.print("Enter the updated song's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the updated song's artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter the updated song's genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter the updated album name: ");
        String album_name = sc.nextLine();
        boolean updated = songDao.updateSong(name, artist, genre, album_name);
        if (updated) {
            System.out.println("Song updated successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void searchSong() {
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        Optional<Song> song = songDao.searchSong(name);
        song.ifPresent(s -> System.out.println("Found: " + s.getName()));
        song.orElseThrow(() -> new RuntimeException("Song not found"));
    }

    public List<Song> searchSongsByCategory() {
        System.out.println("Please choose a category to display songs by:");
		System.out.println("1. Genre");
		System.out.println("2. Artist");
		System.out.println("3. Album");
		System.out.print("Please type the number of your selected option:");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Please type the keyword for the category you have chosen:");
        String type_name = sc.nextLine();
        try {
            Optional<List<Song>> songsByCategory = songDao.searchSongsByCategory(type, type_name);
            songsByCategory.ifPresentOrElse(
                songs -> songs.forEach(song -> System.out.println("Name: " + song.getName())),
                () -> System.out.println("Song not found")
            );
            return songsByCategory.orElseThrow(() -> new RuntimeException("Song not found"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }

    public void displaySongsByCategory() {
        List<Song> songs = searchSongsByCategory();
        if (songs.isEmpty()) {
            System.out.println("No songs found for the genre");
        } else {
            System.out.println("Songs in genre: ");
            for (Song song : songs) {
                System.out.println(song.toString());
            }
        }
    }

    public void displayAllSongs() {
        List<Song> allSongs = songDao.getAllSongs();
        if (allSongs.isEmpty()) {
            System.out.println("No songs in the catalog.");
        } else {
            System.out.println("All songs in the catalog:");
            for (Song song : allSongs) {
                System.out.println(song.toString());
            }
        }
    }
}

