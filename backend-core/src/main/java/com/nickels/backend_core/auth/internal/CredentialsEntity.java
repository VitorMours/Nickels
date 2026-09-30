package com.nickels.backend_core.auth.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import java.util.UUID;

@Entity 
@Table(name="credentials")
class Credentials {

  @Id 
  @GeneratedValue(strategy= GenerationType.UUID)
  private UUID id

  @Column(nullable=false, unique=true)
  private String email;

  @Column(name="password_hash", nullable=false)
  private String passwordHash;

  protected Credentials(){}
}