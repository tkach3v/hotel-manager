package com.tkachev.comparator.user;

import com.tkachev.entity.User;

import java.util.Comparator;

public class UserIdComparator implements Comparator<User> {
    @Override
    public int compare(User p1, User p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
