package com.gabrego.usersapi.service;

import com.gabrego.usersapi.entity.DetailType;

import java.util.List;

public interface DetailTypeService {
    public List<DetailType> findAll();

    public DetailType findById(int id);

    public void save(DetailType detailType);

    public int deleteById(int id);
}
