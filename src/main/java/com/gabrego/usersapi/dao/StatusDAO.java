package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Status;
import com.gabrego.usersapi.entity.User;

import java.util.List;

public interface StatusDAO {
    public List<Status> findAll();

    public Status findById(int id);

    public void save(Status status);

    public int deleteById(int id);
}
