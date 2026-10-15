package com.nickels.core.users.internal.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nickels.core.users.UserService;
import com.nickels.core.auth.events.CredentialCreated;
import com.nickels.core.users.requests.UserDataRequest;

import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;

@Component 
class CredentialCreatedListener {

  private static final Logger log = LoggerFactory.getLogger(CredentialCreatedListener.class);
  private final UserService service;

  CredentialCreatedListener(UserService service) {
    this.service = service;
  }

  @ApplicationModuleListener
  void on(CredentialCreated event) {
    log.debug("Received CredentialCreated event for user {}", event.email());
    this.service.create(new UserDataRequest(event.name(), event.email()));
    log.info("User created successfully for email {}", event.email());


  }


}