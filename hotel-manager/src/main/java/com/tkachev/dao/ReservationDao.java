package com.tkachev.dao;

import com.tkachev.entity.Reservation;

import java.util.List;

public interface ReservationDao extends GenericDao<Reservation, Integer> {
    @Override
    Reservation add(Reservation entity);

    @Override
    Reservation update(Reservation entity);

    @Override
    void delete(Integer id);

    @Override
    void delete(Reservation entity);

    @Override
    List<Reservation> getAll();

    @Override
    Reservation getById(Integer id);
}
