package com.infosys.dao;

import com.infosys.pojo.*;

public class UserDAO {

    private User[] users = new User[3];

    public void adduser(String userName, int userId, String emailid, String password){
        User user = new User(userName, userId, emailid, password);
        int counter = 0;
		for (User u : users) {
			if (u == null) {
				users[counter] = user;
				break;
			}
			counter++;
		}
        System.out.println("User Added");
    }

    public User finduser(String userName, String password){
        User user = null;
		for (User u : users) {
			if (u != null && u.getUserName().equals(userName) && u.getPassword().equals(password)) {
				user = u;
                break;
			}
		}
        return user;
    }
    
    public boolean removeuser(String userName){
        int counter = 0;
		for (User u : users) {
			if (u.getUserName().equals(userName)) {
				users[counter] = null;
				break;
			}
			counter++;
            if (counter == users.length) {
				return false;
			}
		}
        System.out.println("User Removed");
        return true;
    }


	public void printusers(){
        for(User u : this.users){
            if(u != null){
                System.out.println("user Name: "+u.getUserName() +" user id: "+u.getUserId());
            }
        }    
    }


	
	



}
