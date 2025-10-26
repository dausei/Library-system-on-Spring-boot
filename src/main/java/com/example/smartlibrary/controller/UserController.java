package com.example.smartlibrary.controller;

import com.example.smartlibrary.model.User;
import com.example.smartlibrary.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // это endpoint для создания пользователя
    // он будет реагировать на POST /users
    @PostMapping
    public User registerUser(@RequestBody User u){
        return userService.registerUser(u);
    }

    @GetMapping
    public List<User> listUsers(){
        return userService.listUsers();
    }
}
