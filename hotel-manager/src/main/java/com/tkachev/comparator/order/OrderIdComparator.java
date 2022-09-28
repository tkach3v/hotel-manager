package com.tkachev.comparator.order;

import com.tkachev.entity.Order;

import java.util.Comparator;

public class OrderIdComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
