package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findById(int id);

    public User findByEmail(String email);

    public void save(User user);

    public int deleteById(int id);
}
