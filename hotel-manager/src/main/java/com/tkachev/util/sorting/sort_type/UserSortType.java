package com.tkachev.util.sorting.sort_type;

import com.tkachev.comparator.user.UserIdComparator;
import com.tkachev.comparator.user.UserFirstNameComparator;
import com.tkachev.entity.User;

import java.util.Comparator;

public enum UserSortType {

    BY_ID(new UserIdComparator()),
    BY_NAME(new UserFirstNameComparator());

    private final Comparator<User> comparator;

    UserSortType(Comparator<User> comparator) {
        this.comparator = comparator;
    }

    public Comparator<User> getComparator() {
        return comparator;
    }
}
