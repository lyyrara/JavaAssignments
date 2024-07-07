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
        System.out.print("Enter a podcast's pubDate: yyyy-MM-dd ");
        String pubDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(pubDate, formatter);
        Podcast podcast = new Podcast(title, celebrity, localDate);
        boolean added = podcastDao.addPodcast(podcast); 
        if (added) {
            System.out.println("Podcast added successfully.");
        } else {
            System.out.println("Podcast not added.");
        }   
	}


    public void removePodcast() {
        System.out.print("Enter the podcast's title to remove: ");
        String title = sc.nextLine();
        boolean removed = podcastDao.removePodcast(title);
        if (removed) {
            System.out.println("Podcast removed successfully.");
        } else {
            System.out.println("Podcast not found.");
        }
    }


    public List<Podcast> getPodcastsByCelebrity() {
        System.out.println("Please choose podcast's celebrity to display:");
        String celebrity = sc.nextLine();
        List<Podcast> results = podcastDao.searchCelebrity(celebrity);
        return results;
    }

    public List<Podcast> getPodcastsByPubDate() {
        System.out.println("Please choose podcast's pubDate to display:");
        String pubDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(pubDate, formatter);

        if (localDate != null) {
            System.out.println("Parsed LocalDate: " + localDate);
        } else {
            System.out.println("Invalid date format.");
        }
        return podcastDao.searchPubdate(localDate);
    }

    public void displayPodcastByCategory() {
        System.out.println("Please choose podcast's category to display: 1.Celebrity 2.PubDate");
        int option = sc.nextInt();
        sc.nextLine();
        List<Podcast> results = new ArrayList<>();
        switch (option) {
            case 1:
                results = getPodcastsByCelebrity();
                break;
            case 2:
                results = getPodcastsByPubDate();
                break;
            default:
                throw new AssertionError();
        }
        
        if (results.isEmpty()) {
            System.out.println("No podcast.");
        } else {
            System.out.println("All podcasts:");
            for (Podcast podcast : results) {
                System.out.println(podcast.toString());
            }
        }
        
    }
}

