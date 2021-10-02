package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.MedicalRecord;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<MedicalRecord> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecord> theQuery = currentSession.createQuery("FROM MedicalRecord", MedicalRecord.class);
        List<MedicalRecord> medicalRecords = theQuery.getResultList();
        return medicalRecords;
    }

    @Override
    public MedicalRecord findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        MedicalRecord medicalRecord = currentSession.get(MedicalRecord.class, id);
        return medicalRecord;
    }

    @Override
    public MedicalRecord findByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecord> theQuery = currentSession.createQuery("FROM MedicalRecord WHERE user_id.id=:idUser", MedicalRecord.class);
        theQuery.setParameter("idUser", id);
        return theQuery.uniqueResult();
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(medicalRecord);
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecord> theQuery = currentSession.createQuery("DELETE FROM MedicalRecord WHERE id=:idRecord", MedicalRecord.class);
        theQuery.setParameter("idRecord", id);
        return theQuery.executeUpdate();
    }

    @Override
    public int deleteByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MedicalRecord> theQuery = currentSession.createQuery("DELETE FROM MedicalRecord WHERE user_id.id=:idUser", MedicalRecord.class);
        theQuery.setParameter("idUser", id);
        return theQuery.executeUpdate();
    }
}
