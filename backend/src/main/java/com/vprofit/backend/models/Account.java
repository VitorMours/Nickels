package com.vprofit.backend.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity 
@Table(name="tb_account")
public class Account implements Serializable {

  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column 
  private String name; 
  @Column 
  private boolean multipleUsers;
  
  @Column
  private boolean isActive;

  @Column 
  private Instant createdAt;
  @Column 
  private Instant updatedAt;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false)
  private User user;

  protected Account() {}

  public Account(User user) {
    if(user == null || user.equals("")){
      throw new IllegalArgumentException("Account precisa ter um usuario para existir");
    }
    this.user = user;
  }

  // Getters e Setters 
  // Getters 
  public String getName() {
    return name;
  }
  public User getUser() {
    return user;
  }
  public boolean getIsActive(){
    return isActive;
  }
  public boolean getMultipleUsers(){
    return multipleUsers;
  }
  public Instant getUpdatedAt() {
    return updatedAt;
  }
  public Instant getCreatedAt() {
    return createdAt;
  }

  // Setters 
  public void setName(String name) {
    this.name = name;
  }
  public void setUser(User user) {
    this.user = user;
  }
  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }
  public void setMultipleUsers(boolean multipleUsers) {
    this.multipleUsers = multipleUsers;
  }
  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

}
