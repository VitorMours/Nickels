package com.vprofit.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vprofit.backend.exceptions.ResourceNotFoundException;
import com.vprofit.backend.models.User;
import com.vprofit.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        User createdUser = userRepository.save(newUser);
        return createdUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found "));
    }

    public User updateUser(Long id, User updatedUser) {
        User newUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found to be updated"));

        newUser.setEmail(updatedUser.getEmail());
        newUser.setName(updatedUser.getName());
        newUser.setPassword(updatedUser.getPassword());

        userRepository.save(newUser);
        return newUser;
    }

    public void deleteUser(Long id) {
        User searchUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found to be deleted"));

        if (searchUser.equals(null)) {

        }
        userRepository.deleteById(id);

    }

}
