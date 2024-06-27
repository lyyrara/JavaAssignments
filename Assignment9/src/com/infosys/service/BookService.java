package com.infosys.service;
import com.infosys.dao.*;
import com.infosys.pojo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
    private BookDAO bookDAO = new BookDAO();
    
    private Scanner sc = new Scanner(System.in);

	public void addBook() {
        System.out.print("Enter a book name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter a book id: ");
        int bookId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a author name: ");
        String author_name = sc.nextLine();
        System.out.print("Enter a description: ");
        String description = sc.nextLine();
        bookDAO.addBook(bookName, bookId, author_name, description);
        
	}

    public void removeBook() {
        System.out.print("Enter the book id to remove: ");
        int remove_id = sc.nextInt();
        boolean remove = bookDAO.removeBook(remove_id);
        if(remove){
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book with the given ID not found.");
        }
        
	}

    public void updateBook(){
        System.out.print("Update book id:");
        int BookId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a book name: ");
        String BookName = sc.nextLine();
        System.out.print("Enter a author name: ");
        String Author_name = sc.nextLine();
        System.out.print("Enter a decription: ");
        String decription = sc.nextLine();
        boolean update = bookDAO.updateBook(BookId, BookName,Author_name, decription);
        if(update){
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }
    
    public void searchBook(){
        System.out.print("Search task id:");
        int search_id = sc.nextInt();
        Book book = bookDAO.searchBook(search_id);
        if(book != null){
            System.out.println("Book search successfully.");
        } else {
            System.out.println("Book with the given ID not found.");
        }
    }

    public void assignBook(User u){
        System.out.print("Assign book id:");
        int bookId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter the status: ");
        String status= sc.nextLine();
        boolean assign = bookDAO.getBooksAssigned(u, bookId, status);
        if(assign){
            System.out.println("Task assign successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void displayBook(User u){
        System.out.print("Book status:");
        String status= sc.nextLine();
        ArrayList<Integer> booklist = bookDAO.displayBooks(u, status);
        if(booklist.isEmpty()){
            System.out.println("No Book.");
        }
        else{
            for (int bookid : booklist) {
                Book b = bookDAO.searchBook(bookid);
                System.out.println("Book name: "+b.getBookName()+" Book Id: "+b.getBookId()+" Author name: "+b.getAuthor_name()+" decription: "+b.getDescription()+'\n');
            }  
        }
    }
            
    

}
