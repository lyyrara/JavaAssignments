package com.infosys.controller;
import com.infosys.pojo.*;
import com.infosys.service.*;
import com.infosys.thread.*;
import  java.util.Scanner;



public class BookManager {

    private BookService bookService;
    private UserService userService;
    

    public BookManager(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }


    public static void main(String[] args) throws InterruptedException{
        
        Scanner scanner = new Scanner(System.in);

        BookService bookService = new BookService();
        UserService userService = new UserService();

        BookManager todoManager = new BookManager(bookService, userService);

        while (true) {
            
            System.out.println("1. Register a user");
            System.out.println("2. Login in");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
    
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
    
            switch (option) {
                case 1:
                    userService.addUser();;
                    break;
                case 2:
                    User currentUser = userService.loginUser();
                    if (currentUser != null) {
                        //todoManager.displayBookMenu(currentUser);
                        Thread thread = new UserThread(currentUser, userService, bookService);
                        thread.start();
                        try{
                            thread.join();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
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
  /*   public void displayBookMenu(User user){
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Add a book");
            System.out.println("2. Update a book");
            System.out.println("3. Delete a book");
            System.out.println("4. Search a book");
            System.out.println("5. Assign a book");
            System.out.println("6. Display books");
        
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            switch (option) {
                case 1:
                    bookService.addBook();
                    break;
                case 2:
                    bookService.updateBook();
                    break;
                case 3:
                    bookService.removeBook();
                    break;
                case 4:
                    bookService.searchBook();
                    break;
                case 5:
                    bookService.assignBook(user);
                    break;
                case 6:
                    bookService.displayBook(user);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }*/
        

        
}
        
    
    
    
    
    

