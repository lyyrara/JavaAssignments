package com.infosys.dao;
import com.infosys.pojo.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao {
    private List<Playlist> playlists;
    

    public PlaylistDao() {
		this.playlists = new ArrayList<>();
    }


    public boolean addPlaylist(Playlist playlist) {
		if(this.playlists == null){
            this.playlists = new ArrayList<>();
        }
		this.playlists.add(playlist);
        return true;
	
	}

    public boolean removePlaylist(String name) {
		for (Playlist playlist : playlists) {
			if (playlist.getName().equalsIgnoreCase(name)) {
				playlists.remove(playlist);
				return true;
			}
		}
		return false;
	}

	public Playlist getPlaylistByName(String name) {
		Playlist result = null;
		for (Playlist playlist : playlists) {
			if (playlist.getName().equalsIgnoreCase(name)) {
				result = playlist;
			}
		}
		if(result == null){
            System.out.println("Playlist not found: " + name);
        }
		else{
			System.out.println("Playlist found: " + name);
		}
		return result;
	}

	public boolean addSongToPlaylist(Song song, String playlist_name){
		Playlist playlist = getPlaylistByName(playlist_name);
		playlist.getSongs().add(song);
		System.out.println("Song added to playlist: " + playlist_name);
		return true;
	
	}



	public boolean addPodcastToPlaylist(Podcast podcast, String playlist_name){
		Playlist playlist = getPlaylistByName(playlist_name);	
		playlist.getPodcasts().add(podcast);
		System.out.println("Podcast added to playlist: " + playlist_name);
		return true;

		
	}

	public List<Playlist> getAllPlaylists() {
        return playlists;
    }
}
