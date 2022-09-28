package com.tkachev.controller.impl;

import com.tkachev.controller.ReservationController;
import com.tkachev.dto.ReservationDto;
import com.tkachev.service.ReservationService;
import com.tkachev.util.sorting.sort_type.ReservationSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.SortOrder;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationControllerImpl implements ReservationController {

    @Autowired
    private ReservationService reservationService;
//    @Autowired
//    private BrokerService brokerService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('reservations:write')")
    public ReservationDto addReservation(@RequestBody ReservationDto reservationDto) {
        ReservationDto entity =
                reservationService.getReservationById(reservationService.addReservation(reservationDto).getId());

//        brokerService.sendMessage(entity);

        return entity;
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('reservations:read')")
    public ReservationDto getReservationById(@PathVariable("id") Integer id) {
        return reservationService.getReservationById(id);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('reservations:write')")
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.updateReservation(reservationDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('reservations:write')")
    public String deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);

        return "Reservation with ID = " + id + " has been deleted";
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('reservations:read')")
    public List<ReservationDto> getReservations(@RequestParam(name = "sort-type", defaultValue = "BY_ID") ReservationSortType sortType,
                                                @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder) {
        return reservationService.getReservations(sortType, sortOrder);
    }

    @Override
    @GetMapping("/guests")
    @PreAuthorize("hasAuthority('reservations:read')")
    public List<ReservationDto> getGuestReservations(@RequestParam(name = "sort-type", defaultValue = "BY_ID") ReservationSortType sortType,
                                                     @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder) {

        return reservationService.getGuestReservations(sortType, sortOrder);
    }

    @Override
    @GetMapping("/guests/amount")
    @PreAuthorize("hasAuthority('reservations:read')")
    public long getNumberOfGuests() {
        return reservationService.getNumberOfGuests();
    }

    @Override
    @GetMapping("/{id}/bill")
    @PreAuthorize("hasAuthority('reservations:read')")
    public Double getBill(@PathVariable("id") Integer reservationId) {
        return reservationService.getBill(reservationId);
    }

    @Override
    @GetMapping("/last-guests")
    @PreAuthorize("hasAuthority('reservations:read')")
    public List<ReservationDto> getLastGuestReservations(
            @RequestParam(name = "room-id") Integer roomId,
            @RequestParam(name = "until-date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date untilDate) {

        return reservationService.getLastGuestReservations(roomId, untilDate);
    }
}
