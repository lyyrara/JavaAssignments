package com.infosys.dao;
import com.infosys.pojo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PodcastDao {
    private List<Podcast> podcasts;


    public PodcastDao() {
        this.podcasts = new ArrayList<>();
    }


    public void addPodcast(Podcast podcast) {
		this.podcasts.add(podcast);
	}


    public boolean removePodcast(String title){
        for (int i =0; i < podcasts.size(); i++) {
            if(title.equals(podcasts.get(i).getTitle())){
               podcasts.remove(i); 
               return true;
            }
        }
        return false;
        
    }

    

    public List<Podcast> getAllPodcasts() {
        return podcasts;
    }



    public List<Podcast> searchCelebrity(String celebrity){
        List<Podcast> result = new ArrayList<>();
		for (Podcast podcast : podcasts) {
			if (podcast.getCelebrity().equalsIgnoreCase(celebrity)) {
				result.add(podcast);
			}
		}
		return result;
	}
    
    public List<Podcast> searchPubdate(LocalDate pubDate){
        List<Podcast> result = new ArrayList<>();
		for (Podcast podcast : podcasts) {
			if (podcast.getPubDate().equals(pubDate)) {
				result.add(podcast);
			}
		}
		return result;
	}


}
