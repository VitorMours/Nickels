package com.vprofit.backend.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tb_users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(unique=true, nullable=false)
    private String email;
    
    @Column(nullable=false)
    private Date createdAt;
    
    @Column(nullable=false)
    private Date updatedAt;

    @Column
    private boolean isActive;
    
    @Column(nullable=false)
    private String password;

    protected User(){}

    public User(String name, String email, String password) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("O usuario nao pode ser criado sem nome");
        }
        if(email == null || email.equals("")) {
            throw new IllegalArgumentException("O usuario nao pode ser criado sem email");
        }
        if(password == null || password.equals("")) {
            throw new IllegalArgumentException("O usuario nao pode ser criado sem senha");
        }

        this.name = name;
        this.email = email; 
        this.password = password;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.isActive = true;
    }

    // Getters and Setters 
    // Getter
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getIsActive(){
        return this.isActive;
    }
    public Date getCreatedAt() {
      return createdAt;
    }
    public Date getUpdatedAt() {
      return updatedAt;
    }

    // Setters 
    public void setName(String newName){
        if(newName == null || newName.equals("")){
            throw new IllegalArgumentException("The new value for name cannot be empty or null");
        } else{
            this.name = newName;
    
        }
    }
    public void setEmail(String newEmail){
        if(newEmail == null || newEmail.equals("")){
            throw new IllegalArgumentException("The new value for email cannot be empty or null");
        } else{
            this.email = newEmail; 
        }
    }
    public void setPassword(String newPassword){
        if(newPassword == null || newPassword.equals("")){
            throw new IllegalArgumentException("The new value for password cannot be empty or null");
        } else{
            this.password = newPassword;
        }
    }
    public void setIsActive(boolean newStatus){
        this.isActive = newStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && 
               Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}