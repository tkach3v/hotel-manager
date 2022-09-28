package com.tkachev.dao.impl;

import com.tkachev.dao.AbstractGenericDao;
import com.tkachev.dao.ServiceDao;
import com.tkachev.entity.Service;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDaoImpl extends AbstractGenericDao<Service, Integer> implements ServiceDao {

    public ServiceDaoImpl() {
        super(Service.class);
    }
}
