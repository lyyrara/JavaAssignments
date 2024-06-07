package com.infosys.pojo;

public class Book {

    private  String bookName;
    private  int bookId;
    private  String author_name;
    private  String description;
    

    public Book(String bookName, int bookId, String author_name, String description) {
        this.author_name = author_name;
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
    }
    
    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
