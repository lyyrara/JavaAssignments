package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pojo.User;

@Repository("SuperUserDAOImpl")
public class SuperUserDAOImpl implements IUserDAO {

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User findUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> allUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
