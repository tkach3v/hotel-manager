package com.tkachev.util.sorting.sort_type;

import com.tkachev.comparator.order.OrderDateComparator;
import com.tkachev.comparator.order.OrderIdComparator;
import com.tkachev.comparator.order.OrderServicePriceComparator;
import com.tkachev.entity.Order;

import java.util.Comparator;

public enum OrderSortType {

    BY_ID(new OrderIdComparator()),
    BY_DATE(new OrderDateComparator()),
    BY_SERVICE_PRICE(new OrderServicePriceComparator());

    private final Comparator<Order> comparator;

    OrderSortType(Comparator<Order> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Order> getComparator() {
        return comparator;
    }
}
