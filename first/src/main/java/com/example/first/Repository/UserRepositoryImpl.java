package com.example.first.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.first.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    List<User> users = new ArrayList<>();

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

    

}
