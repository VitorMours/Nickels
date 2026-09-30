package com.nickels.backend_core.user.web;

import java.util.UUID; 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record UserRequest (
  
  
  @NotBlank
  String firstName,

  @NotBlank
  String lastName, 

  @NotBlank
  @Email
  String email,

  @NotBlank
  String password

) {}