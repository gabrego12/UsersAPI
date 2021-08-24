package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.PatientDAO;
import com.gabrego.usersapi.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO patientDAO;

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = patientDAO.findAll();
        return patients;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = patientDAO.findById(id);
        return patient;
    }

    @Override
    public Patient findByUserId(int id) {
        Patient patient = patientDAO.findByUserId(id);
        return patient;
    }

    @Override
    public void save(Patient patient) {
        patientDAO.save(patient);
    }

    @Override
    public int deleteById(int id) {
        return patientDAO.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        return patientDAO.deleteByUserId(id);
    }
}
