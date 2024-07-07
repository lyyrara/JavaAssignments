package com.infosys.dao;
import com.infosys.pojo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongDao {
    
    private List<Song> catalog;

    
    public SongDao() {
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
                        .filter(song -> song.getName().equals(name))
                        .findFirst();
    }

    public List<Song> getAllSongs() {
        return catalog;
    }


    public Optional<List<Song>> searchSongsByCategory(int type, String type_name) {
        if(type_name == null || catalog == null){
            return Optional.empty();
        }
        List<Song> songsByCategory = new ArrayList<>();
        switch (type) {
            case 1:
                songsByCategory = catalog.stream()
                                                .filter(song -> song.getGenre().equals(type_name) )
                                                .sorted((o1, o2)->o1.getName().compareTo(o2.getName()))
                                                .collect(Collectors.toList());
                break;
            case 2:
                songsByCategory = catalog.stream()
                                                .filter(song -> song.getArtist().equals(type_name) )
                                                .sorted((o1, o2)->o1.getName().compareTo(o2.getName()))
                                                .collect(Collectors.toList());
                break;
            case 3:
                songsByCategory = catalog.stream().filter(song -> song.getAlbum_name().equals(type_name) )
                                                .sorted((o1, o2)->o1.getName().compareTo(o2.getName()))
                                                .collect(Collectors.toList());
                break;
            default:
                return Optional.empty();
        }
        return Optional.ofNullable(songsByCategory) ;
    }

    
}
