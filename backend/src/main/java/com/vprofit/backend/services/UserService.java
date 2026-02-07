package com.vprofit.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vprofit.backend.models.User;
import com.vprofit.backend.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    // CREATE
    public User create(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        user.setIsActive(true);
        user.setUpdatedAt(new Date());

        return userRepository.save(user);
    }

    // READ ALL
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // READ ONE
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // UPDATE
    public User update(Long id, User userData) {

        User user = findById(id);

        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setUpdatedAt(new Date());

        return userRepository.save(user);
    }

    // DELETE (soft delete)
    public void deactivate(Long id) {

        User user = findById(id);
        user.setIsActive(false);
        user.setUpdatedAt(new Date());

        userRepository.save(user);
    }
}
