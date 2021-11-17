package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.Status;

import java.util.List;

public interface StatusService {
    public List<Status> findAll();

    public Status findById(int id);

    public void save(Status status);

    public int deleteById(int id);
}
