package com.infosys.pojo;

public class Task {
    private int taskId;
	private String taskTitle;
    private String taskText;
    private String assignedTo; 
    private boolean isCompleted;


    public Task() {
    }

    public Task(int taskId, String taskTitle, String taskText) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.assignedTo = ""; 
        this.isCompleted = false;
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

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setTaskId(int taskId) {
        this.taskId= taskId;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setCompleted() {
        this.isCompleted = true;
    }


}
