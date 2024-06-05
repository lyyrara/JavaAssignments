import java.util.ArrayList;
import java.util.List;

public class Task {
    private List<String> tasks;

    public Task(){
        this.tasks = new ArrayList<String> ();
    }


    public void addTask(String task){
        this.tasks.add(task);
        printTasks();
    }

    public void removeTask(String task){
        this.tasks.remove(task);
        printTasks();
    }
    
    public void printTasks(){
        System.out.println("Tasks of the day:");
        for(String task: this.tasks){
            System.out.println(task);
        }    
    }
    
    public void updateTask(String task, String new_task){
        for(int i = 0; i < this.tasks.size(); i++){
            if(this.tasks.get(i).equals(task)){
                this.tasks.set(i, new_task);
                printTasks();
                return;
            }
        }
    }

    public void searchTask(String task){
        for(int i = 0; i < this.tasks.size(); i++){
            if(this.tasks.get(i).equals(task)){
                System.out.println("Found task: "+task);
                return;
            }
        }
        System.out.println("Not found task: "+task);       
    }

}
