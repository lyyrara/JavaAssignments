package com.infosys.controller;
import com.infosys.service.*;
import java.util.Scanner;



public class Jukebox {

    private SongService songService;
    private PodcastService podcastService;
    private PlaylistService playlistService;


    public Jukebox() {
        this.songService = new SongService();
        this.podcastService = new PodcastService();
        this.playlistService = new PlaylistService();
    }


    public static void main(String[] args){

        Jukebox jukebox = new Jukebox();

        while (true) {
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Add a song");
            System.out.println("2. Update a song");
            System.out.println("3. Delete a song");
            System.out.println("4. Search a song");
            System.out.println("5. Display all songs");
            System.out.println("6. Display songs by category");
            System.out.println("7. Add a Podcast");
		    System.out.println("8. Display Podcasts");
            System.out.println("9. Make a New Playlist");
		    System.out.println("10. Add Song/Podcast to your Playlist");
		    System.out.println("11. Show Playlist");
		    
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            switch (option) {
                case 1:
                    jukebox.songService.addSong();
                    break;
                case 2:
                    jukebox.songService.updateSong();
                    break;
                case 3:
                    jukebox.songService.removeSong();
                    break;
                case 4:
                    jukebox.songService.searchSong();;
                    break;
                case 5:
                    jukebox.songService.displayAllSongs();
                    break;
                case 6:
                    jukebox.songService.displaySongsByCategory();
                    break;
                case 7:
                    jukebox.podcastService.addPodcast();
                    break;
                case 8:
                    jukebox.podcastService.displayPodcastByCategory();
                    break;
                case 9:
                    jukebox.playlistService.addPlaylist();
                    break;
                case 10:
                    jukebox.playlistService.addPlaylistByCategory();
                    break;
                case 11:
                    jukebox.playlistService.displayPlaylistByName();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            }

        
    }
}
  