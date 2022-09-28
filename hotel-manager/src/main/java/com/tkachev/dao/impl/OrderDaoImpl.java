package com.tkachev.dao.impl;

import com.tkachev.dao.AbstractGenericDao;
import com.tkachev.dao.OrderDao;
import com.tkachev.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractGenericDao<Order, Integer> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }
}
