package com.tkachev.util.sorting.sort_type;

import com.tkachev.comparator.service.ServiceIdComparator;
import com.tkachev.comparator.service.ServicePriceComparator;
import com.tkachev.entity.Service;

import java.util.Comparator;

public enum ServiceSortType {

    BY_ID(new ServiceIdComparator()),
    BY_PRICE(new ServicePriceComparator());

    private final Comparator<Service> comparator;

    ServiceSortType(Comparator<Service> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Service> getComparator() {
        return comparator;
    }
}
