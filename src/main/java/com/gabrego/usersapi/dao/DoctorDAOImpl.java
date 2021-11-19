package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Doctor> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Doctor> theQuery = currentSession.createQuery("FROM Doctor", Doctor.class);
        List<Doctor> doctors = theQuery.getResultList();
        return doctors;
    }

    @Override
    public List<Doctor> findByClinicId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Doctor> theQuery = currentSession.createQuery("FROM Doctor WHERE clinic_id.id=:idClinica", Doctor.class);
        theQuery.setParameter("idClinica", id);
        List<Doctor> doctors = theQuery.getResultList();
        return doctors;
    }

    @Override
    public Doctor findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Doctor doctor = currentSession.get(Doctor.class, id);
        return doctor;
    }

    @Override
    public Doctor findByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Doctor> theQuery = currentSession.createQuery("FROM Doctor WHERE user_id.id=:idUser", Doctor.class);
        theQuery.setParameter("idUser", id);
        return theQuery.uniqueResult();
    }

    @Override
    public void save(Doctor doctor) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(doctor);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Doctor> theQuery = currentSession.createQuery("DELETE FROM Doctor WHERE id=:idPatient");
        theQuery.setParameter("idPatient", id);
        return theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public int deleteByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Doctor> theQuery = currentSession.createQuery("DELETE FROM Doctor WHERE user_id.id=:idUser");
        theQuery.setParameter("idUser", id);
        return theQuery.executeUpdate();
    }
}
