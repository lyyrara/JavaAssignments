package com.infosys.thread;
import com.infosys.exceptions.TaskCreationException;
import com.infosys.exceptions.TaskNotFoundException;
import com.infosys.pojo.*;
import com.infosys.service.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ClientThread extends Thread{

    User user;
    TaskService taskService;
    UserService userService;


    
    public ClientThread(User user, TaskService taskService, UserService userService) {
        this.user = user;
        this.taskService = taskService;
        this.userService = userService;
    }



    @Override
    public void run() {
        
    
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
                            taskService.displayTask(user.getuserName());
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
                   
                }
                catch (InputMismatchException e) {
                    System.out.println("please input a number value");
                }
                catch (NullPointerException e) {
                    System.out.println("Task list is null.");
                }
            }

    }
}
