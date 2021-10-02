package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordDAO {
    public List<MedicalRecord> findAll();

    public MedicalRecord findById(int id);

    public MedicalRecord findByUserId(int id);

    public void save(MedicalRecord medicalRecord);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
