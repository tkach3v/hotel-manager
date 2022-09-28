package com.tkachev.service.impl;

import com.tkachev.dao.ReservationDao;
import com.tkachev.dao.RoomDao;
import com.tkachev.dto.RoomDto;
import com.tkachev.entity.Room;
import com.tkachev.entity.RoomStatus;
import com.tkachev.mapper.RoomMapper;
import com.tkachev.service.AbstractService;
import com.tkachev.service.RoomService;
import com.tkachev.util.sorting.sort_type.RoomSortType;
import com.tkachev.util.sorting.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl extends AbstractService implements RoomService {
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private RoomMapper mapper;
    @Value("${CHANGE_ROOM_STATUS}")
    private Boolean CHANGE_ROOM_STATUS;

    @Override
    @Transactional
    public RoomDto addRoom(RoomDto roomDto) {
        isSpecified(roomDto.getNumber(), "Room number");
        isSpecified(roomDto.getPrice(), "Room price");
        isSpecified(roomDto.getCapacity(), "Room capacity");
        isSpecified(roomDto.getStatus(), "Room status");
        isSpecified(roomDto.getRating(), "Rating must");

        return mapper.entityToDto(roomDao.add(mapper.dtoToEntity(roomDto)));
    }

    @Override
    @Transactional
    public RoomDto getRoomById(Integer id) {
        return mapper.entityToDto(isExist(roomDao.getById(id), "Room"));
    }

    @Override
    @Transactional
    public void deleteRoom(Integer id) {
        roomDao.delete(isExist(roomDao.getById(id), "Room"));
    }

    @Override
    @Transactional
    public RoomDto updateRoom(RoomDto roomDto) {
        Room entity = isExist(roomDao.getById(roomDto.getId()), "Room");

        isSpecified(roomDto.getNumber(), "Room number");
        isSpecified(roomDto.getPrice(), "Room price");
        isSpecified(roomDto.getCapacity(), "Room capacity");
        isSpecified(roomDto.getStatus(), "Room status");
        isSpecified(roomDto.getRating(), "Rating");

        if (Boolean.TRUE.equals(!CHANGE_ROOM_STATUS) && roomDto.getStatus() != entity.getStatus()) {
            roomDto.setStatus(entity.getStatus());
        }

        mapper.updateEntityByDto(entity, roomDto);

        return mapper.entityToDto(roomDao.update(entity));
    }

    @Override
    @Transactional
    public List<RoomDto> getRooms(RoomSortType sortType, SortOrder sortOrder, RoomStatus status) {
        List<Room> roomList = getRooms(status);
        Comparator<Room> comparator = sortType.getComparator();
        roomList = Sorter.sort(roomList, comparator, sortOrder);

        return roomList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    private List<Room> getRooms(RoomStatus status) {
        List<Room> roomList;

        if (status == null) {
            roomList = roomDao.getAll();
        } else {
            roomList = roomDao.getAll()
                    .stream()
                    .filter(i -> i.getStatus() == status)
                    .toList();
        }

        return roomList;
    }

    @Override
    @Transactional
    public long getNumberOfRooms(RoomStatus status) {
        return getRooms(status).size();
    }

    @Override
    @Transactional
    public List<RoomDto> getAvailableRooms(Date dateStart, Date dateEnd) {
        return roomDao.getAll().stream()
                .filter(i -> reservationDao.getAll().
                        stream().
                        filter(r -> r.getRoom()
                                .getId()
                                .equals(i.getId()))
                        .allMatch(k ->
                                (dateStart.before(k.getDateStart()) && dateEnd.before(k.getDateStart())) ||
                                        (dateStart.after(k.getDateEnd()) && dateEnd.after(k.getDateEnd())))
                        && i.getStatus() != RoomStatus.RENOVATION)
                .map(mapper::entityToDto)
                .toList();
    }
}
