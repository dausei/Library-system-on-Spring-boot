package com.example.smartlibrary.repository;

import com.example.smartlibrary.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private long nextId = 1;
    private Map<Long, User> users = new HashMap<>();

    public User saveUser(User u){
        if (u.getId() == 0) {
            u.setId(nextId);
            nextId++;
        }
        users.put(u.getId(), u);
        return u;
    }

    public User findById(Long id){
        return users.get(id);
    }

    public List<User> listUsers(){
        return new ArrayList<>(users.values());
    }
}