import java.util.Scanner;


public class TodoManager {

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
    
        while (true) {
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Update a task");
            System.out.println("4. Search a task");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
    
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
    
            switch (option) {
                case 1:
                    taskService.addTask();
                    break;
                case 2:
                    taskService.removeTask();;
                    break;
                case 3:
                    taskService.updateTask();
                    break;
                case 4:
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
