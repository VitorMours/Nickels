package com.vprofit.backend.models;


import com.vprofit.backend.models.User;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


public class UserModelTests {
    
    private User user; 

    @BeforeEach 
    void setUp(){
        user = new User();
    }

    @Test
    void assert_createuser_withDefault_emptyConstructor() {
        assertNotNull(user, "The instance returned by the user class is null");
        assertInstanceOf(User.class, user, "The instance of the asserttion it's not from the user type");
    }
}
