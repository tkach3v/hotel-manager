package com.tkachev.util.sorting.sort_type;

import com.tkachev.comparator.reservation.ReservationUserFirstNameComparator;
import com.tkachev.comparator.reservation.ReservationDateEndComparator;
import com.tkachev.comparator.reservation.ReservationIdComparator;
import com.tkachev.entity.Reservation;

import java.util.Comparator;

public enum ReservationSortType {

    BY_ID(new ReservationIdComparator()),
    BY_USER_FIRST_NAME(new ReservationUserFirstNameComparator()),
    BY_DATE_END(new ReservationDateEndComparator());


    private final Comparator<Reservation> comparator;

    ReservationSortType(Comparator<Reservation> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Reservation> getComparator() {
        return comparator;
    }
}
