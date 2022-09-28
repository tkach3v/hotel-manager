package com.tkachev.comparator.service;

import com.tkachev.entity.Service;

import java.util.Comparator;

public class ServicePriceComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
