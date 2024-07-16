package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pojo.User;

@Repository("UserDAOImpl")
public class UserDAOImpl implements IUserDAO{
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
        
    }

    @Override
    public List<User> allUsers() {
        
        return users;
    }

    @Override
    public User findUser(String userId) {
        User user = null;
        for(User u: users){
            if(u.getUserId().equals(userId)){
                user = u;
                break;
            }
        }
        return user;
    }
    
}
