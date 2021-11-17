package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.MedicalRecordDetail;

import java.util.List;

public interface MedicalDetailService {
    public List<MedicalRecordDetail> findAll();

    public MedicalRecordDetail findById(int id);

    public List<MedicalRecordDetail> findByAppointmentId(int id);

    public List<MedicalRecordDetail> findByPatientId(int id);

    public void save(MedicalRecordDetail medicalRecordDetail);

    public int deleteById(int id);

    public int deleteByAppointmentId(int id);
}
