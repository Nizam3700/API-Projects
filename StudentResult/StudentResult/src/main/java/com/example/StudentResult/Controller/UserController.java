package com.example.StudentResult.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.StudentResult.Model.User;
import com.example.StudentResult.Service.UserService;

import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // get All user data 
    @GetMapping("/user")
    public Optional<User> getMethodName() {
        Optional<User> user = userService.getAll();
        return user;
    }

    // get the user data 
    @GetMapping("user/{id}")
    public User getUser(@PathVariable Integer id) {
        Optional<User> user = userService.getUser(id);

        if(user.isPresent()){
            return (User)user.get();
        }
        return null;
    }
    

    // Delete the user id and details 
    @DeleteMapping("user/{id}")
    public Optional<User> putupdate(@PathVariable Integer id) {
        Optional<User> user = userService.removeUser(id);
        return user;
        
    }
    

    
}
    
    
    
    

