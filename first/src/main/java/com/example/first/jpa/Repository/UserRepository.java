package com.example.first.jpa.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.first.jpa.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByUserIdAndPassword(String userId, String password);

    //public User updateUser();

//     @Query(value = "select * from users", nativeQuery = true)
//     public List<User> fetchAllUsers();

//     @Query(value="select * from users where user_id= ?", nativeQuery=true)
//     public User getUser(Integer userId);

//     @Query(value = "Select * from users where user_id = ?", nativeQuery = true)
// 	public Optional<User> fetchUser(int user_id);
}
