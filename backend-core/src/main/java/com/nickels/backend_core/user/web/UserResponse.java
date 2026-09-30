package com.nickels.backend_core.user.web;

import com.nickels.backend_core.user.web.UserView;
import java.util.UUID; 

public record UserResponse (UUID id, String firstName, String lastName, String password){
  public static UserResponse from(UserView user) {
    return new UserResponse(
      user.id(),
      user.firstName(),
      user.lastName(),
      user.password()
    );
  }
}