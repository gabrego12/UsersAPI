package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public User findByEmail(String email);

    public void save(User user);

    public int deleteById(int id);
}
