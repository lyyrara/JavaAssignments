package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.pojo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PodcastService {
    private PodcastDao podcastDao;

    private Scanner sc;

    public PodcastService() {
        podcastDao = new PodcastDao();
        sc  = new Scanner(System.in);
    }
    
    public void addPodcast() {
        System.out.print("Enter a podcast's title: ");
        String title = sc.nextLine();
        System.out.print("Enter a podcast's celebrity: ");
        String celebrity = sc.nextLine();
        System.out.print("Enter a podcast's pubDate: ");
        String pubDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate localDate = LocalDate.parse(pubDate, formatter);
        Podcast podcast = new Podcast(title, celebrity, localDate);
        podcastDao.addPodcast(podcast);    
	}


    public void removePodcast() {
        System.out.print("Enter the podcast's title to remove: ");
        String title = sc.nextLine();
        boolean removed = podcastDao.removePodcast(title);
        if (removed) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }


    public List<Podcast> getPodcastsByCelebrity() {
        System.out.println("Please choose podcast's celebrity to display:");
        String celebrity = sc.nextLine();
        return podcastDao.searchCelebrity(celebrity);
    }

    public List<Podcast> getPodcastsByPubDate() {
        System.out.println("Please choose podcast's pubDate to display:");
        String pubDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate localDate = LocalDate.parse(pubDate, formatter);

        if (localDate != null) {
            System.out.println("Parsed LocalDate: " + localDate);
        } else {
            System.out.println("Invalid date format.");
        }
        return podcastDao.searchPubdate(localDate);
    }

    public void displayPodcastByCategory() {
        System.out.println("Please choose podcast's category to display:");
        String category = sc.nextLine();
        List<Podcast> podcasts = new ArrayList<>();
        if(category.equals("Celebrity")){
            System.out.println("Please choose podcast's celebrity to display:");
            String celebrity = sc.nextLine();
            podcasts = podcastDao.searchCelebrity(celebrity);
        }
        else if(category.equals("PubDate")){
            System.out.println("Please choose podcast's pubDate to display:");
            String pubDate = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
            LocalDate localDate = LocalDate.parse(pubDate, formatter);
            podcasts = podcastDao.searchPubdate(localDate);
        }
        
        if (podcasts.isEmpty()) {
            System.out.println("No podcast.");
        } else {
            System.out.println("All podcasts:");
            for (Podcast podcast : podcasts) {
                System.out.println(podcast.toString());
            }
        }
        
    }
}

