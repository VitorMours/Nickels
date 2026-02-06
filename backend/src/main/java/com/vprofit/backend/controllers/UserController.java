package com.vprofit.backend.controllers;


import java.util.List; 

import com.vprofit.backend.models.User;
import com.vprofit.backend.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;


@RequestMapping("users")
@RestController
public class UserController {

  @Autowired
  private UserService userService; 
    

  @GetMapping 
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok().body(userService.findAll());
  }


  @PostMapping 
  public ResponseEntity<User> createUser(@RequestBody User newUser){
    User createdUser = userService.create(newUser);
    return ResponseEntity.ok(createdUser);
  

  }

}
