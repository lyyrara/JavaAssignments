package com.infosys.thread;
import com.infosys.pojo.*;
import com.infosys.service.*;
import java.util.Scanner;

public class UserThread extends Thread{
    User user;
    UserService userService;
    BookService bookService;

    public UserThread(User user, UserService userService, BookService bookService) {
        this.user = user;
        this.userService = userService;
        this.bookService = bookService;
    }
    public void run() {
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
        }
    }