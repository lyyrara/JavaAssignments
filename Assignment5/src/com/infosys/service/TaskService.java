package com.infosys.service;
import com.infosys.dao.*;
import com.infosys.pojo.*;
import java.util.ArrayList;
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

    public void assignTask(){
        System.out.print("Assign task id:");
        int taskId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a user name: ");
        String username = sc.nextLine();
        boolean assign = taskDAO.assignTask(taskId, username);
        if(assign){
            System.out.println("Task assign successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void displayTask(String username){
        System.out.print("Display order:");
        String order= sc.nextLine();
        
        ArrayList<Task> tasklist = taskDAO.displayTasks(username);
        if(order.equals("increasing")) {
            tasklist.sort((task1, task2) -> Integer.compare(task1.getTaskId(), task2.getTaskId()));
        } else if(order.equals("decreasing")) {
            tasklist.sort((task1, task2) -> Integer.compare(task2.getTaskId(), task1.getTaskId()));
        }
        
        if(tasklist.isEmpty()){
            System.out.println("No Task.");
        }
        else{
            for(Task t: tasklist){
                if(t != null){
                    System.out.println("taskid: "+t.getTaskId()+" taskname: "+ t.getTaskTitle() +" tasktext: "+t.getTaskText());
                }
            } 
        }    
    }

    public void completeTask(){
        System.out.print("Assign task id:");
        int taskId = sc.nextInt();
        
        boolean isCompleted = taskDAO.completeTask(taskId);
        if(isCompleted){
            System.out.println("Task complete successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public void listTask(String username){
        System.out.print("Task status:");
        String status= sc.nextLine();
        ArrayList<Task> tasklist = taskDAO.displayTasks(username);
        ArrayList<Task> tasks = new ArrayList<>();
        if(status.equals("completed")) {
            for (Task t : tasklist) {
                if (t!= null && t.isCompleted()) {
                    tasks.add(t);
                }  
            }
        } 
        else if(status.equals("incompleted")) {
            for (Task t : tasks) {
                if (t!= null && !t.isCompleted()) {
                    tasks.add(t);
                } 
            }  
        }
        if(tasks.isEmpty()){
            System.out.println("No Task.");
        }
        else{
            for(Task t: tasks){
                if(t != null){
                    System.out.println("taskid: "+t.getTaskId()+" taskname: "+ t.getTaskTitle() +" tasktext: "+t.getTaskText());
                }
            } 
        }
    
    }
}
