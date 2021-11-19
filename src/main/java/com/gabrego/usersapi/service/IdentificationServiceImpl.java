package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.IdentificationDAO;
import com.gabrego.usersapi.entity.Identification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificationServiceImpl implements IdentificationService{

    @Autowired
    private IdentificationDAO identificationDAO;

    @Override
    public List<Identification> findAll() {
        return identificationDAO.findAll();
    }

    @Override
    public Identification findById(int id) {
        return identificationDAO.findById(id);
    }

    @Override
    public void save(Identification identification) {
        identificationDAO.save(identification);
    }

    @Override
    public int deleteById(int id) {
        return identificationDAO.deleteById(id);
    }
}
