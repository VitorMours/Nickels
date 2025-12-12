package com.vprofit.backend.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.vprofit.backend.models.User; 
import com.vprofit.backend.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired 
    private UserService userService;

    @GetMapping 
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usersList = userService.getAllUsers(); 
        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping 
    public ResponseEntity<User> createUser(@RequestBody User newUser){  
        User createdUser = userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        User updated = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok().body(updated);
    }
}
