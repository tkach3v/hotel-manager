package com.tkachev.controller;

import com.tkachev.dto.ReservationDto;
import com.tkachev.util.sorting.sort_type.ReservationSortType;

import javax.swing.SortOrder;
import java.util.Date;
import java.util.List;

public interface ReservationController {

    ReservationDto addReservation(ReservationDto reservationDto);

    ReservationDto getReservationById(Integer id);

    ReservationDto updateReservation(ReservationDto reservationDto);

    String deleteReservation(Integer id);

    List<ReservationDto> getReservations(ReservationSortType sortType, SortOrder sortOrder);

    List<ReservationDto> getGuestReservations(ReservationSortType sortType, SortOrder sortOrder);

    long getNumberOfGuests();

    Double getBill(Integer reservationId);

    List<ReservationDto> getLastGuestReservations(Integer roomId, Date untilDate);
}
