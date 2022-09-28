package com.tkachev.dao;

import com.tkachev.entity.Room;

import java.util.List;

public interface RoomDao extends GenericDao<Room, Integer> {
    @Override
    Room add(Room entity);

    @Override
    Room update(Room entity);

    @Override
    void delete(Integer id);

    @Override
    void delete(Room entity);

    @Override
    List<Room> getAll();

    @Override
    Room getById(Integer id);
}
