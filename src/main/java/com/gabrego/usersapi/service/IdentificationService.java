package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.Identification;

import java.util.List;

public interface IdentificationService {
    public List<Identification> findAll();

    public Identification findById(int id);

    public void save(Identification identification);

    public int deleteById(int id);
}
