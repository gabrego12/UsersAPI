package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.DoctorDAO;
import com.gabrego.usersapi.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorDAO.findAll();
        return doctors;
    }

    @Override
    public Doctor findById(int id) {
        Doctor doctor = doctorDAO.findById(id);
        return doctor;
    }

    @Override
    public Doctor findByUserId(int id) {
        Doctor doctor = doctorDAO.findByUserId(id);
        return doctor;
    }

    @Override
    public void save(Doctor doctor) {
        doctorDAO.save(doctor);
    }

    @Override
    public int deleteById(int id) {
        return doctorDAO.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        return doctorDAO.deleteByUserId(id);
    }
}
