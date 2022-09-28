package com.tkachev.service.impl;

import com.tkachev.dao.UserDao;
import com.tkachev.dao.ReservationDao;
import com.tkachev.dao.RoomDao;
import com.tkachev.dto.ReservationDto;
import com.tkachev.entity.Reservation;
import com.tkachev.entity.Room;
import com.tkachev.entity.RoomStatus;
import com.tkachev.mapper.ReservationMapper;
import com.tkachev.service.AbstractService;
import com.tkachev.service.ReservationService;
import com.tkachev.util.sorting.Sorter;
import com.tkachev.util.sorting.sort_type.ReservationSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReservationMapper mapper;
    @Value("${NUMBER_OF_ENTRIES_IN_ROOM_HISTORY}")
    private Integer NUMBER_OF_ENTRIES_IN_ROOM_HISTORY;

    @Override
    @Transactional
    public ReservationDto addReservation(ReservationDto reservationDto) {
        isSpecified(reservationDto.getDateStart(), "Date start");
        isSpecified(reservationDto.getDateEnd(), "Date end");
        isSpecified(reservationDto.getUser(), "User");
        isSpecified(reservationDto.getRoom(), "Room");
        isExist(userDao.getById(reservationDto.getUser().getId()), "User");

        Room room = isExist(roomDao.getById(reservationDto.getRoom().getId()), "Room");

        if (new Date().after(reservationDto.getDateStart()) &&
                new Date().before(reservationDto.getDateEnd())) {

            room.setStatus(RoomStatus.OCCUPIED);
            roomDao.update(room);
        }

        return mapper.entityToDto(reservationDao.add(mapper.dtoToEntity(reservationDto)));
    }

    @Override
    @Transactional
    public void deleteReservation(Integer id) {
        reservationDao.delete(isExist(reservationDao.getById(id), "Reservation"));
    }

    @Override
    @Transactional
    public ReservationDto updateReservation(ReservationDto reservationDto) {
        Reservation entity = isExist(reservationDao.getById(reservationDto.getId()), "Reservation");

        isSpecified(reservationDto.getDateStart(), "Date start");
        isSpecified(reservationDto.getDateEnd(), "Date end");
        isSpecified(reservationDto.getUser(), "User");
        isSpecified(reservationDto.getRoom(), "Room");
        isExist(roomDao.getById(reservationDto.getRoom().getId()), "Room");
        isExist(userDao.getById(reservationDto.getUser().getId()), "User");

        mapper.updateEntityByDto(entity, reservationDto);

        return mapper.entityToDto(reservationDao.update(entity));
    }

    @Override
    @Transactional
    public List<ReservationDto> getReservations(ReservationSortType sortType, SortOrder sortOrder) {
        Comparator<Reservation> comparator = sortType.getComparator();
        List<Reservation> reservationList = reservationDao.getAll();
        reservationList = Sorter.sort(reservationList, comparator, sortOrder);

        return reservationList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public ReservationDto getReservationById(Integer id) {
        return mapper.entityToDto(isExist(reservationDao.getById(id), "Reservation"));
    }

    @Override
    @Transactional
    public List<ReservationDto> getGuestReservations(ReservationSortType sortType, SortOrder sortOrder) {
        Comparator<Reservation> comparator = sortType.getComparator();

        List<Reservation> reservationList = reservationDao.getAll().stream()
                .filter(i ->
                        i.getRoom().getStatus() == RoomStatus.OCCUPIED &&
                                new Date().after(i.getDateStart()) &&
                                new Date().before(i.getDateEnd())).toList();

        reservationList = Sorter.sort(reservationList, comparator, sortOrder);

        return reservationList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public long getNumberOfGuests() {
        return reservationDao.getAll().stream()
                .filter(i ->
                        i.getRoom().getStatus() == RoomStatus.OCCUPIED &&
                                new Date().after(i.getDateStart()) &&
                                new Date().before(i.getDateEnd()))
                .map(Reservation::getUser)
                .distinct()
                .count();
    }

    @Override
    @Transactional
    public Double getBill(Integer reservationId) {
        Reservation reservation = isExist(reservationDao.getById(reservationId), "Reservation");

        long diffInMillis = Math.abs(reservation.getDateEnd().getTime() - reservation.getDateStart().getTime());

        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) * reservation.getRoom().getPrice();
    }

    @Override
    @Transactional
    public List<ReservationDto> getLastGuestReservations(Integer roomId, Date untilDate) {
        isExist(roomDao.getById(roomId), "Room");

        return getReservations(ReservationSortType.BY_DATE_END, SortOrder.DESCENDING)
                .stream()
                .filter(i -> i.getDateEnd()
                        .before(untilDate) &&
                        i.getRoom()
                                .getId()
                                .equals(roomId))
                .limit(NUMBER_OF_ENTRIES_IN_ROOM_HISTORY)
                .toList();
    }
}
