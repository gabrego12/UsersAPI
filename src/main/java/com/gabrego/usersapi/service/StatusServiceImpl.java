package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.StatusDAO;
import com.gabrego.usersapi.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusDAO statusDAO;

    @Override
    public List<Status> findAll() {
        return statusDAO.findAll();
    }

    @Override
    public Status findById(int id) {
        return statusDAO.findById(id);
    }

    @Override
    public void save(Status status) {
        statusDAO.save(status);
    }

    @Override
    public int deleteById(int id) {
        return statusDAO.deleteById(id);
    }
}
