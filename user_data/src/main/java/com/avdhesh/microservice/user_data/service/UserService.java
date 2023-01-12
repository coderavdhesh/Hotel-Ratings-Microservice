package com.avdhesh.microservice.user_data.service;

import java.util.List;

import com.avdhesh.microservice.user_data.entities.User;

public interface UserService {
    
    // retiriving data
    User getUser(String UserID);
    List<User> getAllUsers();

    // createing data
    User createUser(User user);

    // deleting data
    void deleteUser(String userID);

    // updating data
    User updateUser(String userId, User user);
}
