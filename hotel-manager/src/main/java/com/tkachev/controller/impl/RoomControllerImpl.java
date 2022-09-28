package com.tkachev.controller.impl;

import com.tkachev.controller.RoomController;
import com.tkachev.dto.RoomDto;
import com.tkachev.entity.RoomStatus;
import com.tkachev.service.RoomService;
import com.tkachev.util.sorting.sort_type.RoomSortType;
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
@RequestMapping("/rooms")
public class RoomControllerImpl implements RoomController {

    @Autowired
    private RoomService roomService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('rooms:write')")
    public RoomDto addRoom(@RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('rooms:read')")
    public RoomDto getRoomById(@PathVariable("id") Integer id) {
        return roomService.getRoomById(id);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('rooms:write')")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomService.updateRoom(roomDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('rooms:write')")
    public String deleteRoom(@PathVariable("id") Integer id) {
        roomService.deleteRoom(id);

        return "Room with ID = " + id + " has been deleted";
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('rooms:read')")
    public List<RoomDto> getRooms(@RequestParam(name = "sort-type", defaultValue = "BY_ID") RoomSortType sortType,
                               @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder,
                               @RequestParam(name = "status", required = false) RoomStatus status) {

        return roomService.getRooms(sortType, sortOrder, status);
    }

    @Override
    @GetMapping("/amount")
    @PreAuthorize("hasAuthority('rooms:read')")
    public long getNumberOfRooms(@RequestParam(name = "status", required = false) RoomStatus status) {
        return roomService.getNumberOfRooms(status);
    }

    @Override
    @GetMapping("/available")
    @PreAuthorize("hasAuthority('rooms:read')")
    public List<RoomDto> getAvailableRooms(@RequestParam(name = "date-start") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateStart,
                                        @RequestParam(name = "date-end") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateEnd) {

        return roomService.getAvailableRooms(dateStart, dateEnd);
    }
}
