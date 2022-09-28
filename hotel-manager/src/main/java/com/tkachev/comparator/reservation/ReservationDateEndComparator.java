package com.tkachev.comparator.reservation;

import com.tkachev.entity.Reservation;

import java.util.Comparator;

public class ReservationDateEndComparator implements Comparator<Reservation> {
    @Override
    public int compare(Reservation o1, Reservation o2) {
        return o1.getDateEnd().compareTo(o2.getDateEnd());
    }
}
