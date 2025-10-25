package com.example.smartlibrary.repository;

import com.example.smartlibrary.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private long nextId = 1;
    private Map<Long, User> users = new HashMap<>();

    public User saveUser(User u){
        u.setId(nextId);
        users.put(u.getId(), u);
        nextId++;
        return u;
    }

    public User findById(long id){
        return users.get(id);
    }

    public List<User> listUsers(){
        return new ArrayList<>(users.values());
    }
}
