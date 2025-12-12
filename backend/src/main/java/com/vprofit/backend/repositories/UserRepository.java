package com.vprofit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vprofit.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
