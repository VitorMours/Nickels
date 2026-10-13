package com.nickels.core.auth.internal;

import java.util.UUID;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nickels.core.users.UserDto;
import com.nickels.core.users.UserService;
import com.nickels.core.auth.CrendetialDto;
import com.nickels.core.auth.CredentialService;
import com.nickels.core.auth.requests.LoginUserRequest;
import com.nickels.core.users.requests.UserDataRequest;
import com.nickels.core.auth.requests.CreateUserRequest;
import com.nickels.core.auth.internal.CredentialRepository;

@Service 
public class CredentialServiceImpl implements CredentialService {

  private final static Logger log = LoggerFactory.getLogger(CredentialServiceImpl.class);
  private final UserService userService;
  private final CredentialRepository authRepository;
  private final PasswordEncoder passwordEncoder;

  CredentialServiceImpl(UserService userService, CredentialRepository authRepository, PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.authRepository = authRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional
  public CredentialDto signupUser(CreateUserRequest request) {
    if (authRepository.existsByUserEmail(request.email())) {
      log.warn("Tentativa de criação de credenciais para email já cadastrado: {}", request.email());
      throw new EmailAlreadyRegisteredException(request.email());
    }

    UserDto userDto = userService.create(
        new UserDataRequest(request.name(), request.email()));

    Credential credential = authRepository.save(
        new Credential(userDto.id(), passwordEncoder.encode(request.password())));

    log.info("Credentials created with success for the user {}", userDto.id());
    return new CredentialDto(credential.getId() /*, demais campos */);
  }
  
  @Override
  @Transactional
  public CredentialDto loginUser(LoginUserRequest request) {
    return authRepository.findByUserEmail(request.email())
      .filter(c -> isPasswordValid(request.password(), c.getPassword()))
      .map(c -> new CredentialDto(c.getId() /*, ... */))
      .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
  }
  
  public boolean isEmailRegistered(String email) {
    return authRepository.existsByUserEmail(email);
  }


  private boolean isPasswordValid(String rawPassword, String encodedPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
  }

}