package com.infosys.pojo;

import java.util.ArrayList;

public class User {
    
    private String userName;
    private  int userId;
    private  String emailid;
    private String password;
    ArrayList<Integer> newBooks;
    ArrayList<Integer> favourite;
    ArrayList<Integer> completed;

    public User(String userName, int userId, String emailid, String password) {
        this.userName = userName;
        this.userId = userId;
        this.emailid = emailid; 
        this.password = password;
        this.newBooks = new ArrayList<>();
        this.favourite = new ArrayList<>();  
        this.completed = new ArrayList<>();      
    }

    public String getUserName() {
        return userName;
    }


    public int getUserId() {
        return userId;
    }

    
    public String getEmailid() {
        return emailid;
    }


    public String getPassword() {
        return password;
    }


    public ArrayList<Integer> getNewBooks() {
        return newBooks;
    }
 

    public ArrayList<Integer> getFavourite() {
        return favourite;
    }


    public ArrayList<Integer> getCompleted() {
        return completed;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNewBooks(ArrayList<Integer> newBooks) {
        this.newBooks = newBooks;
    }

    public void setFavourite(ArrayList<Integer> favourite) {
        this.favourite = favourite;
    }

    public void setCompleted(ArrayList<Integer> completed) {
        this.completed = completed;
    }

    public void addBookStatus(int bookId, String status) {
        if(status.equals("new")){
            this.newBooks.add(bookId);
        }
        else if(status.equals("favourite")){
            this.favourite.add(bookId);
        }
        else if(status.equals("completed")){
            this.completed.add(bookId);
        }
        
    }
}
