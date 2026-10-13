package com.nickels.core.auth;

import java.util.UUID;
import java.util.Optional;
import com.nickels.core.auth.requests.LoginUserRequest;
import com.nickels.core.auth.requests.CreateUserRequest;

public interface CredentialService {
  CredentialDto signupUser(CreateUserRequest request);
  CredentialDto loginUser(LoginUserRequest request);
  boolean isEmailRegistered(String email);
}