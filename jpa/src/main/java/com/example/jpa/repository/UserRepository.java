package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.User;


@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByUsernameAndPassword(Integer username, String password);

    public List<User> findByPasswordLessThan(String password);
	
	public List<User> findByPasswordLessThanEqual(String password);

    @Query(value="select * from users", nativeQuery = true)
    public List<User> fetchAllUsers();

    @Query(value="select * from users where user_id=?", nativeQuery= true)
    public User getUser(int user_id);

    @Query(value="select * from users where user_id = ?",nativeQuery = true)
    public Optional<User> fetchUser(int user_id);

    

}
