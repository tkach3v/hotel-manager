package com.tkachev.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T add(T entity);

    T update(T entity);

    void delete(PK id);

    void delete(T entity);

    List<T> getAll();

    T getById(PK id);
}
