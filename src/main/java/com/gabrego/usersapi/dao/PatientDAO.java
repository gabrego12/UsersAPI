package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Patient;
import com.gabrego.usersapi.entity.User;

import java.util.List;

public interface PatientDAO {
    public List<Patient> findAll();

    public Patient findById(int id);

    public Patient findByUserId(int id);

    public void save(Patient patient);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
