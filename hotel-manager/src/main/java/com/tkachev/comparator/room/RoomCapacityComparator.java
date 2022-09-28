package com.tkachev.comparator.room;

import com.tkachev.entity.Room;

import java.util.Comparator;

public class RoomCapacityComparator implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        return r1.getCapacity().compareTo(r2.getCapacity());
    }
}
