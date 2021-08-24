package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> findAll();

    public Patient findById(int id);

    public Patient findByUserId(int id);

    public void save(Patient patient);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
