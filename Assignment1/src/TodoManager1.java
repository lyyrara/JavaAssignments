import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;


public class TodoManager1 {
    private String name;
    private ArrayList<String> tasks;

    public TodoManager1(String name){
        this.name = name;
        this.tasks = new ArrayList<String> ();
    }

    public void printName(){
        System.out.println("User's Name: " + this.name);
    }

    public void addTask(String task){
        this.tasks.add(task);
    }

    public void removeTask(String task){
        this.tasks.remove(task);
    }
    
    public void printTasks(){
        System.out.println("Tasks of the day:");
        for(String task: this.tasks){
            System.out.println(task);
        }    
    }
    
    public void displayTasks(String order){
        if(order.equals("increasing")){
            Collections.sort(this.tasks);
            printTasks();
        }
        else if(order.equals("decreasing")){
            Collections.sort(tasks, Collections.reverseOrder());
            printTasks();
        }
    }

    public void findDuplicates() {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> duplicates = new HashSet<>();


        for (String task : this.tasks) {
            if (seen.contains(task)) {
                duplicates.add(task);
            }
            else{
                seen.add(task);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate tasks:");
            for (String duplicate : duplicates) {
                System.out.println(duplicate);
            }
        }
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
    
        TodoManager1 manager = new TodoManager1(name);
    
        while (true) {
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Display tasks");
            System.out.println("4. Show duplicare tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
    
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
    
            switch (option) {
                case 1:
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();
                    manager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task name to remove: ");
                    String delete_task = scanner.nextLine();
                    manager.removeTask(delete_task);
                    break;
                case 3:
                    System.out.print("Enter the order to display: (increasing/decreasing)");
                    String order = scanner.nextLine();
                    manager.displayTasks(order);
                    break;
                case 4:
                    manager.findDuplicates();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    
}