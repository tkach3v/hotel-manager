package com.tkachev.controller;

import com.tkachev.dto.ServiceDto;
import com.tkachev.util.sorting.sort_type.ServiceSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface ServiceController {

    ServiceDto addService(ServiceDto serviceDto);

    ServiceDto getServiceById(Integer id);

    ServiceDto updateService(ServiceDto serviceDto);

    String deleteService(Integer id);

    List<ServiceDto> getServices(ServiceSortType sortType, SortOrder sortOrder);
}
