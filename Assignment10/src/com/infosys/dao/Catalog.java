package com.infosys.dao;
import com.infosys.pojo.*;
import java.util.ArrayList;
import java.util.Optional;

public class Catalog {
    
    private ArrayList<Song> catalog;

    
    public Catalog() {
        this.catalog = new ArrayList<>();
    }


    public void addSong(String name, String artist, String genre, String album_name){
        Song song = new Song(name, artist, genre, album_name);
        catalog.add(song);        
    }


    public boolean removeSong(String name){
        for (int i =0; i < catalog.size(); i++) {
            if(name.equals(catalog.get(i).getName())){
               catalog.remove(i); 
               return true;
            }
        }
        return false;
        
    }
    
    
    public boolean updateSong(String name, String artist, String genre, String album_name){
        for (int i =0; i < catalog.size(); i++) {
            if(name.equals(catalog.get(i).getName())){
				catalog.get(i).setArtist(artist);
                catalog.get(i).setGenre(genre);
                catalog.get(i).setAlbum_name(album_name);
				return true;
			}
        }
        return false;
    }

    public Optional<Song> searchSong(String name){
        return catalog.stream()
        .filter(song -> song.getName().equalsIgnoreCase(name))
        .findFirst();
    }

    public ArrayList<Song> getAllSongs() {
        return catalog;
    }


    public ArrayList<Song> searchSongsByCategory(String genre) {
        ArrayList<Song> songsByCategory = new ArrayList<>();
        for (Song song : catalog) {
            if (genre.equals(song.getGenre())) {
                songsByCategory.add(song);
            }
        }
        return songsByCategory;
    }
}
