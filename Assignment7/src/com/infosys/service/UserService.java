package com.infosys.service;

import com.infosys.dao.*;
import com.infosys.exceptions.LoginUserException;
import com.infosys.exceptions.UserNotFoundException;
import com.infosys.exceptions.UserRegistrationException;
import com.infosys.pojo.*;
import java.util.Scanner;



public class UserService {
    private UserDAO userDAO = new UserDAO();
    
    private Scanner sc = new Scanner(System.in);

	public void addUser() throws UserRegistrationException {
        System.out.print("Enter a user name: ");
        String userName = sc.nextLine(); 
        System.out.print("Enter a first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter a last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        System.out.print("Enter a role: Client/Visitor");
        String role = sc.nextLine();
        boolean adduser = userDAO.adduser(userName,firstName, lastName, password, role);
        if(adduser){
            System.out.println("User added successfully.");
        } else {
            throw new UserRegistrationException("User added failed.");
        }
        
	}

    public void removeUser() throws UserNotFoundException {
        
        System.out.print("Enter the user name to remove: ");
        String userName = sc.nextLine();
        boolean remove = userDAO.removeuser(userName);
        if(remove){
            System.out.println("User removed successfully.");
        } else {
            throw new UserNotFoundException("Cannot find user.");
        }
                
	}

    public User loginUser() throws LoginUserException {
        System.out.print("Enter the user name: ");
        String userName = sc.nextLine();
        System.out.print("Enter the user password: ");
        String password = sc.nextLine();
        User user = userDAO.finduser(userName, password);
        if (user != null) {
            System.out.println("User found");
        } else {
            throw new LoginUserException("Login failed.");
        }        
        return user;
    }

    

    
}
