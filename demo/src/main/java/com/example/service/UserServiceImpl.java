package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.dao.IUserDAO;
import com.example.pojo.User;
import com.example.until.ConnectionUtil;

@Service
@Scope("prototype")
public class UserServiceImpl implements IUserService{
    @Autowired
    @Qualifier(value = "UserDAOImpl")
    IUserDAO userDAO;

    @Autowired
    ConnectionUtil connectionUtil;

    @Autowired
	@Qualifier(value = "t2")
	Thread thread;
	
	@Autowired
	@Qualifier(value = "t1")
	Thread thread2;

    @Override
    public void saveUser(User user) {
		
		System.out.println("The value is "+connectionUtil.value+" the thread is "+thread.getName());
		userDAO.addUser(user);
	}
	
	

    @Override
    public User searchUser(String userId) {
		System.out.println("The value is "+connectionUtil.value+" the thread is "+thread2.getName());
		return userDAO.findUser(userId);
	}
    
}
