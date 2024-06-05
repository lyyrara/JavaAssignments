import java.util.Scanner;


public class TodoManager {

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        TaskService taskService = new TaskService();
        UserService userService = new UserService();

        while (true) {
            System.out.println("1. Register a user");
            System.out.println("2. Login in");
            System.out.println("3. Add a task");
            System.out.println("4. Remove a task");
            System.out.println("5. Update a task");
            System.out.println("6. Search a task");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
    
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
    
            switch (option) {
                case 1:
                    userService.addUser();;
                    break;
                case 2:
                    userService.loginUser();
                    break;
                case 3:
                    taskService.addTask();
                    break;
                case 4:
                    taskService.removeTask();;
                    break;
                case 5:
                    taskService.updateTask();
                    break;
                case 6:
                    taskService.searchTask();
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
