package com.example.first.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.first.model.User;
import lombok.val;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    List<User> users = new ArrayList<>();
    
    public UserRepositoryImpl() {
		
		User user1 = new User("eileen@123", "123", "Eileen Zheng", "eileen@gmail.com", "Admin");
		User user2 = new User("xi@123", "234", "Xi Wang", "xi@gmail.com", "Manager");
		User user3 = new User("jing@123", "345", "Jing Bai", "jing@gmail.com", "Employee");
		User user4 = new User("zhen@123", "456", "Zhen Luo", "zhen@gmail.com", "Employee");
		
		users.add(user1);  users.add(user2);   users.add(user3);  users.add(user4);
	}

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println(users.size());
    }

    @Override
    public User findUser(String userId, String password) {
        User user = null;
        for(User u: users){
            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){
                user = u;

                break;
            }
        }
        return user;
    }

    

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public String deleteUser(String userId) {
        int index = -1;
        for(int i =0; i < users.size(); i++){
            if(users.get(i).getUserId().equals(userId)){
                index = i;
                break;
            }
        }
        System.err.println("delete"+userId);
        if(index == -1){
            return "User Not found.";
        }
        users.remove(index);
        return "User Deleted";
    }

    @Override
    public User findUser(String userId){
        User u = null;
        for(User value: users){
            if(value.getUserId().equals(userId)){
                u = value;
                break;
            }
        }
        return u;
    }

    @Override
    public void updateUser(User user) {
        int index = 0;
        for(User u: users){
            if(u.getUserId().equals(user.getUserId())){
                break;
            }
            index++;
        }
        users.set(index, user);
       
    }

}
