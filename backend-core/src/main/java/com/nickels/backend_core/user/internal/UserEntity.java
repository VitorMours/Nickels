package com.nickels.backend_core.user.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.util.UUID;


@Entity
@Table(name="users")
class UserEntity {

  @Id 
  @GeneratedValue(strategy=GenerationType.UUID)
  private UUID id; 

  @Column(nullable=false, length=25)
  private String firstName;

  @Column(nullable=false, length=50)
  private String lastName;

  @Column(nullable=false, unique=true)
  private String email;
  
    



  protected User() {}

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;

  }


  

}

