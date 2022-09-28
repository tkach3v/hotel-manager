package com.tkachev.dao.impl;

import com.tkachev.dao.AbstractGenericDao;
import com.tkachev.dao.ReservationDao;
import com.tkachev.entity.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl extends AbstractGenericDao<Reservation, Integer> implements ReservationDao {

    public ReservationDaoImpl() {
        super(Reservation.class);
    }
}
