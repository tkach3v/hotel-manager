package com.tkachev.comparator.service;

import com.tkachev.entity.Service;

import java.util.Comparator;

public class ServiceIdComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
