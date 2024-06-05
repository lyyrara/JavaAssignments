import java.security.PublicKey;
import java.util.Scanner;


public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();
    
    private Scanner sc = new Scanner(System.in);

	public void addTask() {
        System.out.print("Enter a task id: ");
        int taskId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a task title: ");
        String taskTitle = sc.nextLine();
        System.out.print("Enter a task text: ");
        String taskText = sc.nextLine();
        taskDAO.addTask(taskId, taskTitle, taskText);
        
	}

    public void removeTask() {
        System.out.print("Enter the task id to remove: ");
        int remove_id = sc.nextInt();
        boolean remove = taskDAO.removeTask(remove_id);
        if(remove){
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
        
	}

    public void updateTask(){
        System.out.print("Update task id:");
        int idx = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a task title: ");
        String Title = sc.nextLine();
        System.out.print("Enter a task text: ");
        String Text = sc.nextLine();
        boolean update = taskDAO.updateTask(idx, Title, Text);
        if(update){
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }
    
    public void searchTask(){
        System.out.print("Search task id:");
        int search_id = sc.nextInt();
        boolean search = taskDAO.searchTask(search_id);
        if(search){
            System.out.println("Task search successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }


    
}
