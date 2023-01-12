package com.avdhesh.microservice.user_data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.avdhesh.microservice.user_data.entities.User;
import com.avdhesh.microservice.user_data.exception.ResourceNotFoundException;
import com.avdhesh.microservice.user_data.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping(value="/")
    public String homePage() {
        return "This is the Hotel rating website. Thanks for visiting!";
    }

    // getting all users
    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    //single user get
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // creating new user
    @PostMapping(value="/users/add")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping(value="/users/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable String userID) {
        
        try{
            userService.deleteUser(userID);
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted.");
        }
        catch(Exception ex){
            throw new ResourceNotFoundException("There is no such user exixts.");
        }
    }

    @PutMapping(value="users/{userID}")
    public ResponseEntity<User> updating(@RequestBody User user, @PathVariable String userID) {
        User updatedUser = userService.updateUser(userID, user);
        if(updatedUser == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedUser);

        return ResponseEntity.ok().body(updatedUser);
    }
    
}
