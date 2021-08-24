package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Patient> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Patient> theQuery = currentSession.createQuery("FROM Patient", Patient.class);
        List<Patient> patients = theQuery.getResultList();
        return patients;
    }

    @Override
    public Patient findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Patient patient = currentSession.get(Patient.class, id);
        return patient;
    }

    @Override
    public Patient findByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Patient> theQuery = currentSession.createQuery("FROM Patient WHERE user_id.id=:idUser", Patient.class);
        theQuery.setParameter("idUser", id);
        return theQuery.uniqueResult();
    }

    @Override
    public void save(Patient patient) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(patient);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Patient> theQuery = currentSession.createQuery("DELETE FROM Patient WHERE id=:idPatient");
        theQuery.setParameter("idPatient", id);
        return theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public int deleteByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Patient> theQuery = currentSession.createQuery("DELETE FROM Patient WHERE user_id.id=:idUser");
        theQuery.setParameter("idUser", id);
        return theQuery.executeUpdate();
    }
}
