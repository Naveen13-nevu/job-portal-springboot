package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

  
    public User register(User user) {
        return userRepo.save(user);
    }

   
    public Optional<User> login(String email, String password) {

        User user = userRepo.findByEmail(email).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        }

        return Optional.empty();
    }
}