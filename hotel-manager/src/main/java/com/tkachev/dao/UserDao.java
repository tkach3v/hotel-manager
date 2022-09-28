package com.tkachev.dao;

import com.tkachev.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    @Override
    User add(User entity);

    @Override
    User update(User entity);

    @Override
    void delete(Integer id);

    @Override
    void delete(User entity);

    @Override
    List<User> getAll();

    @Override
    User getById(Integer id);
}
