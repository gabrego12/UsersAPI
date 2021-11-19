package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.DetailType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DetailTypeDAOImpl implements DetailTypeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DetailType> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DetailType> theQuery = currentSession.createQuery("FROM DetailType ", DetailType.class);
        return theQuery.getResultList();
    }

    @Override
    public DetailType findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        DetailType detailType = currentSession.get(DetailType.class, id);
        return detailType;
    }

    @Override
    public void save(DetailType detailType) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(detailType);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DetailType> theQuery = currentSession.createQuery("DELETE FROM DetailType WHERE id=:idType");
        theQuery.setParameter("idType", id);
        return theQuery.executeUpdate();
    }
}
