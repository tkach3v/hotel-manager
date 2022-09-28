package com.tkachev.dao.impl;

import com.tkachev.dao.AbstractGenericDao;
import com.tkachev.dao.RoomDao;
import com.tkachev.entity.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl extends AbstractGenericDao<Room, Integer> implements RoomDao {

    public RoomDaoImpl() {
        super(Room.class);
    }
}
