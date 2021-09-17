package com.gabrego.usersapi.dao;

import com.gabrego.usersapi.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("FROM User", User.class);
        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("FROM User WHERE email=:emailUser", User.class);
        theQuery.setParameter("emailUser", email);
        return theQuery.uniqueResult();
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(user);
        transaction.commit();
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("DELETE FROM User WHERE id=:idUser");
        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();
    }
}
