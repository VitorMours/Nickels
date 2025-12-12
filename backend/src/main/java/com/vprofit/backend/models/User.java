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
    
    @Column(nullable=false)
    private String name;
    
    @Column(unique=true, nullable=false)
    private String email;
    
    @Column(nullable=false)
    private Date dateJoined;
    
    @Column(nullable=false)
    private String password;

    public User() {
        this.dateJoined = new Date();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email; 
        this.password = password;
        this.dateJoined = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    public Date getDateJoined() {
        return this.dateJoined;
    }
    
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override 
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
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