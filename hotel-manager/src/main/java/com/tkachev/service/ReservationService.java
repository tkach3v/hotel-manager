package com.tkachev.service;

import com.tkachev.dto.ReservationDto;
import com.tkachev.util.sorting.sort_type.ReservationSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface ReservationService {

    ReservationDto addReservation(ReservationDto reservationDto);

    void deleteReservation(Integer id);

    ReservationDto updateReservation(ReservationDto reservationDto);

    List<ReservationDto> getReservations(ReservationSortType sortType, SortOrder sortOrder);

    ReservationDto getReservationById(Integer id);

    List<ReservationDto> getGuestReservations(ReservationSortType sortType, SortOrder sortOrder);

    long getNumberOfGuests();

    Double getBill(Integer reservationId);

    List<ReservationDto> getLastGuestReservations(Integer roomId, java.util.Date untilDate);
}
