package com.infosys.dao;

import com.infosys.pojo.*;
import java.util.ArrayList;

public class TaskDAO {

    private Task[] tasks = new Task[5];
    

    public boolean addTask(int taskId, String taskTitle, String taskText){
        Task task = new Task(taskId, taskTitle,taskText);
        int counter = 0;
		for (Task t : tasks) {
			if (t == null) {
				tasks[counter] = task;
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

    public boolean removeTask(int taskId) throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
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
    
    public boolean updateTask(int taskId, String taskTitle, String taskText) throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
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

    public boolean searchTask(int taskId) throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
                System.out.println("Found task: "+t.getTaskId()+ " Task Title: " + t.getTaskTitle() + " Task Text: " + t.getTaskText());
                break;
			}
            counter++;
            if (counter == tasks.length) {
				return false;
			}   
        }
        return true;
    }

    public boolean assignTask(int taskId, String username) throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
                t.setAssignedTo(username);
                break;
			}
            counter++;
            if (counter == tasks.length) {
				return false;
			}   
        }
        return true;
    }

    public ArrayList<Task> getTasksAssignedToVisitor(String visitorName) throws NullPointerException{
        ArrayList<Task> assigned = new ArrayList<>();
        for (Task t : tasks) {
			if (t.getAssignedTo().equals(visitorName)) {
                assigned.add(t);
                break;
			}  
        }
        return assigned;
    }

    public ArrayList<Task> displayTasks(String visitorName) throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
        ArrayList<Task> assigned = new ArrayList<>();
        for (Task t : tasks) {
			if (t != null && t.getAssignedTo().equals(visitorName)) {
                assigned.add(t);
                break;
			}  
        }
        return assigned;
    }

    public boolean completeTask(int taskId)throws NullPointerException{
        if (tasks == null) {
            throw new NullPointerException("Task list is null.");
        }
        int counter = 0;
        for (Task t : tasks) {
			if (taskId == t.getTaskId()) {
                t.setCompleted();;
                break;
			}
            counter++;
            if (counter == tasks.length) {
				return false;
			}   
        }
        return true;
    }
    
}