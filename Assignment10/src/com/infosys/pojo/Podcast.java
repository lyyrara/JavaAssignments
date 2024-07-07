package com.infosys.pojo;

import java.time.LocalDate;

public class Podcast {
	private String title;
	private String celebrity;
	private LocalDate pubDate;
    
    public Podcast(String title, String celebrity, LocalDate pubDate) {
        this.title = title;
        this.celebrity = celebrity;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Podcast [title=" + title + ", celebrity=" + celebrity + ", pubDate=" + pubDate + "]";
    }

    
    
}