package com.nickels.core.auth.events;

/**
 * When credentials for a new user are created in the system
 * 
 * Event to represent when a user hit the /signup endpoint and the 
 * credentials were created  successfully in the system.
 * 
 * @param name the name of the user
 * @param email the email of the user
 * @param password the password of the user
 * 
 * @version 0.0.2
 * @since 10-14-2026
 * @author Joao Vitor
 */
public record CredentialCreated(String name, String email, String password) {}