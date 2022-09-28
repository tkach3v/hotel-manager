package com.tkachev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericDao<T, PK extends Serializable> implements GenericDao<T, PK> {
    private final Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    protected AbstractGenericDao(Class<T> type) {
        this.type = type;
    }

    @Override
    public T add(T entity) {
        Session session = getSession();
        session.persist(entity);

        return entity;
    }

    @Override
    public T update(T entity) {
        Session session = getSession();

        session.merge(entity);

        return entity;
    }

    @Override
    public void delete(PK id) {
        T obj = getById(id);

        if (obj != null) {
            delete(obj);
        }
    }

    @Override
    public void delete(T entity) {
        Session session = getSession();

        session.remove(entity);
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(all);

        return allQuery.getResultList();
    }

    @Override
    public T getById(PK id) {
        Session session = getSession();

        return session.get(type, id);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
