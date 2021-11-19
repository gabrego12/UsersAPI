package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Identification;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IdentificationDAOImpl implements IdentificationDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Identification> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Identification> theQuery = currentSession.createQuery("FROM Identification ", Identification.class);
        return theQuery.getResultList();
    }

    @Override
    public Identification findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Identification identification = currentSession.get(Identification.class, id);
        return identification;
    }

    @Override
    public void save(Identification identification) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(identification);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Identification> theQuery = currentSession.createQuery("DELETE FROM Identification WHERE id=:idIdentification");
        theQuery.setParameter("idIdentification", id);
        return theQuery.executeUpdate();
    }
}
