package com.infosys.controller;
import com.infosys.exceptions.*;
import com.infosys.pojo.*;
import com.infosys.service.*;
import com.infosys.thread.ClientThread;
import com.infosys.thread.VisitorThread;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.infosys.thread.*;


public class TodoManager {

    private TaskService taskService;
    private UserService userService;
    

    public TodoManager(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }


    public static void main(String[] args) throws InterruptedException{
        
        Scanner scanner = new Scanner(System.in);

        TaskService taskService = new TaskService();
        UserService userService = new UserService();

        TodoManager todoManager = new TodoManager(taskService, userService);

        while (true) {
            try {
                System.out.println("1. Register a user");
                System.out.println("2. Login in");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
    
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
    
                switch (option) {
                    case 1:
                        userService.addUser();
                        break;
                    case 2:
                        User currentUser = userService.loginUser();
                        if(currentUser.getrole().equals("Client")) {
                            Thread thread = new ClientThread(currentUser, taskService, userService);
                            thread.start();
                            try{
                                thread.join();
                            }catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }else if(currentUser.getrole().equals("Visitor")){
                            Thread thread = new VisitorThread(currentUser, taskService, userService);
                            thread.start();
                            try{
                                thread.join();
                            }catch (InterruptedException e) {
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
                
            } catch (UserRegistrationException | LoginUserException e) {
                System.out.println(e.getMessage());
                
            }  
            catch (InputMismatchException e) {
                System.out.println("please input a number value"); 
            }
            
            
        }

        
    }
   /*  public void displayTaskMenu(User user){
        
        String username = user.getuserName();
        if(user.getrole().equals("Client")){
            while (true) {
                try {
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
                } catch (TaskCreationException| TaskNotFoundException e) {
                    System.out.println(e.getMessage());
                    displayTaskMenu(user);
                }
                catch (InputMismatchException e) {
                    System.out.println("please input a number value");
                }
                catch (NullPointerException e) {
                    System.out.println("Task list is null.");
                }
            }
        

        }else if(user.getrole().equals("Visitor")){
            while (true) {
                try {
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
                } catch (TaskCreationException| TaskNotFoundException e) {
                    System.out.println(e.getMessage());
                    displayTaskMenu(user);
                }
                catch (InputMismatchException e) {
                    System.out.println("please input a number value");
                
                }
                catch (NullPointerException e) {
                    System.out.println("Task list is null.");
                }
            }
            
        }
    }*/
   
    
    
}


