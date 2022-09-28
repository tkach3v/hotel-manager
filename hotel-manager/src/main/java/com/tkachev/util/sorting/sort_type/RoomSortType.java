package com.tkachev.util.sorting.sort_type;

import com.tkachev.comparator.room.RoomCapacityComparator;
import com.tkachev.comparator.room.RoomIdComparator;
import com.tkachev.comparator.room.RoomPriceComparator;
import com.tkachev.comparator.room.RoomRatingComparator;
import com.tkachev.entity.Room;

import java.util.Comparator;

public enum RoomSortType {

    BY_ID(new RoomIdComparator()),
    BY_PRICE(new RoomPriceComparator()),
    BY_CAPACITY(new RoomCapacityComparator()),
    BY_RATING(new RoomRatingComparator());

    private final Comparator<Room> comparator;

    RoomSortType(Comparator<Room> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Room> getComparator() {
        return comparator;
    }
}
