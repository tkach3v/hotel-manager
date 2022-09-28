package com.tkachev.controller;

import com.tkachev.dto.RoomDto;
import com.tkachev.entity.RoomStatus;
import com.tkachev.util.sorting.sort_type.RoomSortType;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.swing.SortOrder;
import java.util.Date;
import java.util.List;

public interface RoomController {

    RoomDto addRoom(RoomDto roomDto);

    RoomDto getRoomById(Integer id);

    RoomDto updateRoom(RoomDto roomDto);

    String deleteRoom(Integer id);

    List<RoomDto> getRooms(RoomSortType sortType, SortOrder sortOrder, RoomStatus status);

    long getNumberOfRooms(RoomStatus status);

    List<RoomDto> getAvailableRooms(Date dateStart, Date dateEnd);
}
