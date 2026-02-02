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

    public User(String name, String email, String password) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("O usuario nao pode ser criado sem nome");
        }
        if(email == null || email.equals("")){ //TODO: Add regex validation
            throw new IllegalArgumentException("O usuario nao pode ser criado sem email");
        }
        if(password == null || password.equals("")){
            throw new IllegalArgumentException("O usuario nao pode ser criado sem senha");
        }

        this.name = name;
        this.email = email; 
        this.password = password;
        this.createdAt = new Date();
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

    // Setters 
    public void setName(String newName){
        this.name = newName;
    }

    public void setEmail(String newEmail){
       this.email = newEmail; 
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
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