package com.gabrego.usersapi.service;

import com.gabrego.usersapi.dao.DetailTypeDAO;
import com.gabrego.usersapi.entity.DetailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailTypeServiceImpl implements DetailTypeService{

    @Autowired
    private DetailTypeDAO detailTypeDAO;

    @Override
    public List<DetailType> findAll() {
        return detailTypeDAO.findAll();
    }

    @Override
    public DetailType findById(int id) {
        return detailTypeDAO.findById(id);
    }

    @Override
    public void save(DetailType detailType) {
        detailTypeDAO.save(detailType);
    }

    @Override
    public int deleteById(int id) {
        return detailTypeDAO.deleteById(id);
    }
}
