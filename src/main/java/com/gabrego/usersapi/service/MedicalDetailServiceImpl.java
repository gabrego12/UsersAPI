package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.MedicalRecordDetailDAO;
import com.gabrego.usersapi.entity.MedicalRecordDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDetailServiceImpl implements MedicalDetailService{

    @Autowired
    MedicalRecordDetailDAO medicalRecordDetailDAO;

    @Override
    public List<MedicalRecordDetail> findAll() {
        return medicalRecordDetailDAO.findAll();
    }

    @Override
    public MedicalRecordDetail findById(int id) {
        return medicalRecordDetailDAO.findById(id);
    }

    @Override
    public List<MedicalRecordDetail> findByAppointmentId(int id) {
        return medicalRecordDetailDAO.findByAppointmentId(id);
    }

    @Override
    public List<MedicalRecordDetail> findByPatientId(int id) {
        return medicalRecordDetailDAO.findByPatientId(id);
    }

    @Override
    public void save(MedicalRecordDetail medicalRecordDetail) {
        medicalRecordDetailDAO.save(medicalRecordDetail);
    }

    @Override
    public int deleteById(int id) {
        return medicalRecordDetailDAO.deleteById(id);
    }

    @Override
    public int deleteByAppointmentId(int id) {
        return medicalRecordDetailDAO.deleteByAppointmentId(id);
    }
}
