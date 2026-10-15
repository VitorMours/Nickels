package com.nickels.core.auth.internal;

import java.util.UUID;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nickels.core.users.UserService;
import com.nickels.core.auth.dto.SignupDto;
import com.nickels.core.auth.dto.CredentialDto;
import com.nickels.core.auth.CredentialService;
import com.nickels.core.auth.events.CredentialCreated;
import com.nickels.core.auth.requests.LoginUserRequest;
import com.nickels.core.users.requests.UserDataRequest;
import com.nickels.core.auth.requests.CreateUserRequest;
import com.nickels.core.auth.internal.CredentialRepository;
import com.nickels.core.shared.Exceptions.EmailAlreadyRegisteredException;

@Service 
public class CredentialServiceImpl implements CredentialService {

  private final static Logger log = LoggerFactory.getLogger(CredentialServiceImpl.class);
  private final CredentialRepository authRepository;
  private final PasswordEncoder passwordEncoder;
  private final ApplicationEventPublisher events;

  CredentialServiceImpl(CredentialRepository authRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher events) {
    this.authRepository = authRepository;
    this.passwordEncoder = passwordEncoder;
    this.events = events;
  }

  @Override
  @Transactional
  public CredentialDto signupUser(CreateUserRequest request) {
    if (authRepository.existsByUserEmail(request.email())) {
      log.warn("Email for user already registered: {}", request.email());
      throw new EmailAlreadyRegisteredException(request.email());
    }

    Credential credential = authRepository.save(new Credential(
      request.email(), 
      passwordEncoder.encode(request.password())
    ));

    log.info("Credentials created with success for the user {}", request.email());
    log.info("Sending the CredentialCreated event for the user {}", request.email());
    events.publishEvent(new CredentialCreated(request.name(), request.email(), request.password()));
    return new CredentialDto(credential.getId(), credential.getUserEmail(), credential.getPassword());
  }
  
  @Override
  @Transactional
  public CredentialDto loginUser(LoginUserRequest request) {
    return authRepository.findByUserEmail(request.email())
      .filter(c -> isPasswordValid(request.password(), c.getPassword()))
      .map(c -> new CredentialDto(c.getId(), c.getUserEmail(), c.getPassword()))
      .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
  }
  
  @Override 
  public boolean isEmailRegistered(String email) {
    return authRepository.existsByUserEmail(email);
  }
  
  private boolean isPasswordValid(String rawPassword, String encodedPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
  }
}