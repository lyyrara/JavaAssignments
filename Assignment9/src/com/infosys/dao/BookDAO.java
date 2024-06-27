package com.infosys.dao;

import com.infosys.pojo.*;
import java.util.ArrayList;

public class BookDAO {

    private Book[] books = new Book[5];
    

    public void addBook(String bookName, int bookId, String author_name, String description){
        Book book = new Book(bookName, bookId, author_name, description);
        int counter = 0;
		for (Book b : books) {
			if (b == null) {
				books[counter] = book;
				break;
			}
			counter++;
		}
        System.out.println("Book Added");
        printBooks();
    }

    public boolean removeBook(int BookId){
        int counter = 0;
        for (Book b : books) {
			if (b != null && BookId == b.getBookId()) {
				books[counter] = null;
				break;
			}
            counter++;
            if (counter == books.length) {
				return false;
			}
        }
        printBooks();
        return true;
    }
    
    public void printBooks(){
        for(Book t: this.books){
            if(t != null){
                System.out.println("Bookid: "+t.getBookId()+" Bookname: "+ t.getBookName() +" Author name: "+t.getAuthor_name()+" decription: "+t.getDescription());
            }
        }    
    }
    
    public boolean updateBook(int BookId, String BookName, String Author_name,String decription){
        int counter = 0;
        for (Book b : books) {
			if (BookId == b.getBookId()) {
				books[counter].setBookName(BookName);
                books[counter].setAuthor_name(Author_name);
                books[counter].setDescription(decription);
				break;
			}
            counter++;
            if (counter == books.length) {
				return false;
			}
        }
        printBooks();
        return true;
    }

    public Book searchBook(int BookId){
        Book book = null;
        for (Book b : books) {
			if (BookId == b.getBookId()) {
                System.out.println("Found Book: "+b.getBookId()+ " Book Name: " + b.getBookName());
                book = b;
                break;
			}  
        }
        return book;
    }

    

    public boolean getBooksAssigned(User u, int bookId, String status) {
        Book book = searchBook(bookId);
        if (book == null) {
            return false;
        }
        u.addBookStatus(bookId, status);
        return true;
    }

    public ArrayList<Integer> displayBooks(User user, String status) {
        ArrayList<Integer> idlist = new ArrayList<>();
        if(status.equals("new")){
            idlist = user.getNewBooks();
        }
        else if(status.equals("favourite")){
            idlist = user.getFavourite();
        }
        else if(status.equals("completed")){
            idlist = user.getCompleted();
        }
        return idlist;
    }

    
}