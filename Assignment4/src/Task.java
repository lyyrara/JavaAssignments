
public class Task {
    private int taskId;
	private String taskTitle;
    private String taskText;
    private String assignedTo; 

    public Task() {
    }

    public Task(int taskId, String taskTitle, String taskText) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.assignedTo = ""; 
    }
    
    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskTitle() {
        return this.taskTitle;
    }

    public String getTaskText() {
        return this.taskText;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

}
