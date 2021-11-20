package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.MedicalRecord;
import com.gabrego.usersapi.entity.MedicalRecordDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MedicalRecordDetailDAOImpl implements MedicalRecordDetailDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<MedicalRecordDetail> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("FROM MedicalRecordDetail ", MedicalRecordDetail.class);
        List<MedicalRecordDetail> medicalRecordDetails = theQuery.getResultList();
        return medicalRecordDetails;
    }

    @Override
    public MedicalRecordDetail findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        MedicalRecordDetail medicalRecordDetail = currentSession.get(MedicalRecordDetail.class, id);
        return medicalRecordDetail;
    }

    @Override
    public List<MedicalRecordDetail> findByAppointmentId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("FROM MedicalRecordDetail WHERE appointment_id.id=:idAppointment", MedicalRecordDetail.class);
        theQuery.setParameter("idAppointment", id);
        return theQuery.getResultList();
    }

    @Override
    public List<MedicalRecordDetail> findByUserIdAndTypeId(int userId, int typeId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("FROM MedicalRecordDetail WHERE appointment_id.patient_id.id=:idPatient AND detailType_id.id=:idType", MedicalRecordDetail.class);
        theQuery.setParameter("idPatient", userId);
        theQuery.setParameter("idType", typeId);
        List<MedicalRecordDetail> medicalRecordDetails = theQuery.getResultList();
        return medicalRecordDetails;
    }

    @Override
    public List<MedicalRecordDetail> findByPatientId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("FROM MedicalRecordDetail WHERE appointment_id.patient_id.id=:idPatient", MedicalRecordDetail.class);
        theQuery.setParameter("idPatient", id);
        List<MedicalRecordDetail> medicalRecordDetails = theQuery.getResultList();
        return medicalRecordDetails;
    }

    @Override
    public void save(MedicalRecordDetail medicalRecordDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(medicalRecordDetail);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("DELETE FROM MedicalRecordDetail WHERE id=:idRecordDetail");
        theQuery.setParameter("idRecordDetail", id);
        return theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public int deleteByAppointmentId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecordDetail> theQuery = currentSession.createQuery("DELETE FROM MedicalRecordDetail WHERE appointment_id.id=:idAppointment", MedicalRecordDetail.class);
        theQuery.setParameter("idAppointment", id);
        return theQuery.executeUpdate();
    }
}
