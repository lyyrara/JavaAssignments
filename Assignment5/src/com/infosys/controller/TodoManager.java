package com.infosys.controller;
import com.infosys.pojo.*;
import com.infosys.service.*;
import java.util.Scanner;


public class TodoManager {

    private TaskService taskService;
    private UserService userService;
    

    public TodoManager(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }


    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        TaskService taskService = new TaskService();
        UserService userService = new UserService();

        TodoManager todoManager = new TodoManager(taskService, userService);

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
                        todoManager.displayTaskMenu(currentUser);
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
    public void displayTaskMenu(User user){
        
        String username = user.getuserName();
        if(user.getrole().equals("Client")){
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("1. Add a task");
                System.out.println("2. Update a task");
                System.out.println("3. Delete a task");
                System.out.println("4. Search a task");
                System.out.println("5. Assign a task");
                System.out.println("6. Display tasks");
            
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
                switch (option) {
                    case 1:
                        taskService.addTask();
                        break;
                    case 2:
                        taskService.updateTask();
                        break;
                    case 3:
                        taskService.removeTask();
                        break;
                    case 4:
                        taskService.searchTask();
                        break;
                    case 5:
                        taskService.assignTask();
                        break;
                    case 6:
                        taskService.displayTask(username);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        

        }else if(user.getrole().equals("Visitor")){
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("1. List tasks");
                System.out.println("2. Complete a task");
                System.out.println("3. Display tasks");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
                switch (option) {
                    case 1:
                        taskService.listTask(username);
                        break;
                    case 2:
                        taskService.completeTask();
                        break;
                    case 3:
                        taskService.displayTask(username);
                        break;
                    case 0:
                        System.out.println("Exitin...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                    
    
                    }
                }
            
            }
        }
        
    
    
    
    
    
}
