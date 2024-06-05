
public class TaskManager {

    private Task[] tasks = new Task[5];
    

    public void addTask(Task task){
        if(task.getTaskId()> tasks.length){
            System.out.println("Out of limit");
        }
        this.tasks[task.getTaskId() -1] = task;
    
    }

    public void removeTask(int taskId){
        if (taskId > tasks.length) {
            System.out.println("Out of limit");
            return;
        }
        if (tasks[taskId] != null) {
                tasks[taskId].setTaskTitle("");
                tasks[taskId].setTaskText("");
            }
        }

    }
    
    public void printTasks(){
        for(Task task: this.tasks){
            System.out.println("taskid: "+task.taskId+"taskname: "+ task.taskTitle +"tasktext: "+task.taskText);
        }    
    }
    
    public void updateTask(int taskId, String taskTitle, String taskText){
        if(taskId > tasks.length){
            System.out.println("Out of limit");
        }
        if(tasks[taskId - 1] != null){
            tasks[taskId - 1].setTaskTitle(taskTitle);
            tasks[taskId - 1].setTaskText(taskText);
        }
    }

    public void searchTask(int taskId){
        if(tasks[taskId - 1] != null){
            Task task = tasks[taskId - 1];
            System.out.println("Found task: "+taskId+ " Task Title: " + task.getTaskTitle() + " Task Text: " + task.getTaskText());
        }
        else{
        System.out.println("Not found task: "+taskId);       
        }
    }
}