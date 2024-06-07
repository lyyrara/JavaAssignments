

public class TaskDAO {

    private Task[] tasks = new Task[5];
    

    public void addTask(int taskId, String taskTitle, String taskText){
        Task task = new Task(taskId, taskTitle,taskText);
        int counter = 0;
		for (Task t : tasks) {
			if (t == null) {
				tasks[counter] = task;
				break;
			}
			counter++;
		}
        System.out.println("Task Added");
        printTasks();
    }

    public boolean removeTask(int taskId){
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
				tasks[counter] = null;
				break;
			}
            counter++;
            if (counter == tasks.length) {
				return false;
			}
        }
        printTasks();
        return true;
    }
    
    public void printTasks(){
        for(Task t: this.tasks){
            if(t != null){
                System.out.println("taskid: "+t.getTaskId()+" taskname: "+ t.getTaskTitle() +" tasktext: "+t.getTaskText());
            }
        }    
    }
    
    public boolean updateTask(int taskId, String taskTitle, String taskText){
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
				tasks[counter].setTaskTitle(taskTitle);
                tasks[counter].setTaskText(taskText);
				break;
			}
            counter++;
            if (counter == tasks.length) {
				return false;
			}
        }
        printTasks();
        return true;
    }

    public boolean searchTask(int taskId){
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
                System.out.println("Found task: "+t.getTaskId()+ " Task Title: " + t.getTaskTitle() + " Task Text: " + t.getTaskText());
                break;
			}
            counter++;
            if (counter == tasks.length -1) {
				return false;
			}   
        }
        return true;
    }
}