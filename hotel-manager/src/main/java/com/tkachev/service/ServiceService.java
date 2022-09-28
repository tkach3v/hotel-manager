package com.tkachev.service;

import com.tkachev.dto.ServiceDto;
import com.tkachev.util.sorting.sort_type.ServiceSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface ServiceService {
    ServiceDto addService(ServiceDto serviceDto);

    void deleteService(Integer id);

    ServiceDto updateService(ServiceDto serviceDto);

    List<ServiceDto> getServices(ServiceSortType sortType, SortOrder sortOrder);

    ServiceDto getServiceById(Integer id);
}
