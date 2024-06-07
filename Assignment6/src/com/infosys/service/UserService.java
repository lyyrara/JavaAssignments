package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.pojo.*;
import java.util.Scanner;



public class UserService {
    private UserDAO userDAO = new UserDAO();
    
    private Scanner sc = new Scanner(System.in);

	public void addUser() {
        System.out.print("Enter a user name: ");
        String userName = sc.nextLine(); 
        System.out.print("Enter a userId: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter a email: ");
        String emailid= sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        userDAO.adduser(userName,userId, emailid, password);
        
	}

    public void removeUser() {
        System.out.print("Enter the user name to remove: ");
        String userName = sc.nextLine();
        boolean remove = userDAO.removeuser(userName);
        if(remove){
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User with the given userName not found.");
        }
        
	}

    public User loginUser() {
        System.out.print("Enter the user name: ");
        String userName = sc.nextLine();
        System.out.print("Enter the user password: ");
        String password = sc.nextLine();
        User user = userDAO.finduser(userName, password);
        if (user != null) {
            System.out.println("User found");
        } else {
            System.out.println("User not found");
        }        
        return user;
    }

    

    
}
