package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.MedicalRecordDAO;
import com.gabrego.usersapi.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Override
    public List<MedicalRecord> findAll() {
        List<MedicalRecord> medicalRecords = medicalRecordDAO.findAll();
        return medicalRecords;
    }

    @Override
    public MedicalRecord findById(int id) {
        MedicalRecord medicalRecord = medicalRecordDAO.findById(id);
        return medicalRecord;
    }

    @Override
    public MedicalRecord findByUserId(int id) {
        MedicalRecord medicalRecord = medicalRecordDAO.findByUserId(id);
        return medicalRecord;
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordDAO.save(medicalRecord);
    }

    @Override
    public int deleteById(int id) {
        return medicalRecordDAO.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        return medicalRecordDAO.deleteByUserId(id);
    }
}
