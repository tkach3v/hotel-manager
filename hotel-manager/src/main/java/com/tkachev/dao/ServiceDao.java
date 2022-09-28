package com.tkachev.dao;

import com.tkachev.entity.Service;

import java.util.List;

public interface ServiceDao extends GenericDao<Service, Integer> {
    @Override
    Service add(Service entity);

    @Override
    Service update(Service entity);

    @Override
    void delete(Integer id);

    @Override
    void delete(Service entity);

    @Override
    List<Service> getAll();

    @Override
    Service getById(Integer id);
}
