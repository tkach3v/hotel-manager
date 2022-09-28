package com.tkachev.dao;

import com.tkachev.entity.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order, Integer>  {
    @Override
    Order add(Order entity);

    @Override
    Order update(Order entity);

    @Override
    void delete(Integer id);

    @Override
    void delete(Order entity);

    @Override
    List<Order> getAll();

    @Override
    Order getById(Integer id);
}
