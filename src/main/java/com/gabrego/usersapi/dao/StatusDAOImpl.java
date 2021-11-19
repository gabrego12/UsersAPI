package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StatusDAOImpl implements StatusDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Status> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Status> theQuery = currentSession.createQuery("FROM Status", Status.class);
        return theQuery.getResultList();
    }

    @Override
    public Status findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Status status = currentSession.get(Status.class, id);
        return status;
    }

    @Override
    public void save(Status status) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(status);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Status> theQuery = currentSession.createQuery("DELETE FROM Status WHERE id=:idStatus");
        theQuery.setParameter("idStatus", id);
        return theQuery.executeUpdate();
    }
}
