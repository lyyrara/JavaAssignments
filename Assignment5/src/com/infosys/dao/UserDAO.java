package com.infosys.dao;

import com.infosys.pojo.*;

public class UserDAO {

    private User[] users = new User[3];

    public void adduser(String userName, String firstName, String lastName, String password, String role){
        User user = new User(userName, firstName, lastName, password, role);
        int counter = 0;
		for (User u : users) {
			if (u == null) {
				users[counter] = user;
				break;
			}
			counter++;
		}
        System.out.println("User Added");
		printusers();;
    }

    public User finduser(String userName, String password){
        User user = null;
		for (User u : users) {
			if (u != null && u.getuserName().equals(userName) && u.getpassword().equals(password)) {
				user = u;
                break;
			}
		}
		printusers();
        return user;
    }
    
    public boolean removeuser(String userName){
        int counter = 0;
		for (User u : users) {
			if (u.getuserName() == userName) {
				users[counter] = null;
				break;
			}
			counter++;
            if (counter == users.length) {
				return false;
			}
		}
        System.out.println("User Removed");
		printusers();
        return true;
    }


	public void printusers(){
        for(User u : this.users){
            if(u != null){
                System.out.println("user Name: "+u.getuserName() +" firstname: "+u.getfirstName()+" lastname: "+u.getlastName()+ " role:"+u.getrole());
            }
        }    
    }



}
