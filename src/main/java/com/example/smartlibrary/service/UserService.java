package com.example.smartlibrary.service;

import com.example.smartlibrary.model.User;
import com.example.smartlibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User u) {
        return userRepository.saveUser(u);
    }

    public List<User> listUsers(){
        return userRepository.listUsers();
    }
}
