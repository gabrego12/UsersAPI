package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> findAll();

    public  List<Doctor> findByClinicId(int id);

    public Doctor findById(int id);

    public Doctor findByUserId(int id);

    public void save(Doctor doctor);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
