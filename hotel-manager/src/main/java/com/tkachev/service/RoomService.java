package com.tkachev.service;

import com.tkachev.dto.RoomDto;
import com.tkachev.entity.RoomStatus;
import com.tkachev.util.sorting.sort_type.RoomSortType;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.swing.SortOrder;
import java.util.Date;
import java.util.List;

public interface RoomService {

    RoomDto addRoom(RoomDto roomDto);

    void deleteRoom(Integer id);

    RoomDto updateRoom(RoomDto roomDto);

    List<RoomDto> getRooms(RoomSortType sortType, SortOrder sortOrder, RoomStatus status);

    RoomDto getRoomById(Integer id);

    long getNumberOfRooms(RoomStatus status);

    List<RoomDto> getAvailableRooms(Date dateStart, Date dateEnd);
}
