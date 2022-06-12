package com.example.moveez;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    public List<User> getAllUsers();

    @Insert
    public void addUser(User user );

    @Update
    public void update(User user);

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    User getUserById(long id);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password LIMIT 1")
    public User checkIfLoginLegit(String email, String password);

    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    public User getUserByEmail(String email);

    @Query("SELECT id FROM user WHERE email = :email LIMIT 1")
    public int getUserIDByEmail(String email);


}
