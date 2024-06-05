import java.util.Scanner;


public class TodoManager {

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
    
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
                    System.out.print("Enter a task id: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter a task title: ");
                    String taskTitle = scanner.nextLine();
                    System.out.print("Enter a task text: ");
                    String taskText = scanner.nextLine();
                    Task task = new Task(taskId, taskTitle, taskText);
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task id to remove: ");
                    int remove_id = scanner.nextInt();
                    taskManager.removeTask(remove_id);
                    break;
                case 3:
                    System.out.print("Update task id:");
                    int idx = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter a task title: ");
                    String Title = scanner.nextLine();
                    System.out.print("Enter a task text: ");
                    String Text = scanner.nextLine();
                    taskManager.updateTask(idx, Title, Text);
                    break;
                case 4:
                    System.out.print("Search task id:");
                    int search_id = scanner.nextInt();
                    taskManager.searchTask(search_id);
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
