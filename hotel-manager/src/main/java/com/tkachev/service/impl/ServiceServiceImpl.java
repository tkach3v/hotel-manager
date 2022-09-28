package com.tkachev.service.impl;

import com.tkachev.dao.ServiceDao;
import com.tkachev.dto.ServiceDto;
import com.tkachev.entity.Service;
import com.tkachev.mapper.ServiceMapper;
import com.tkachev.service.AbstractService;
import com.tkachev.service.ServiceService;
import com.tkachev.util.sorting.Sorter;
import com.tkachev.util.sorting.sort_type.ServiceSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl extends AbstractService implements ServiceService {
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private ServiceMapper mapper;

    @Override
    @Transactional
    public ServiceDto addService(ServiceDto serviceDto) {
        isSpecified(serviceDto.getName(), "Service name");
        isSpecified(serviceDto.getPrice(), "Service price");

        return mapper.entityToDto(serviceDao.add(mapper.dtoToEntity(serviceDto)));
    }

    @Override
    @Transactional
    public ServiceDto updateService(ServiceDto serviceDto) {
        Service entity = isExist(serviceDao.getById(serviceDto.getId()), "Service");

        isSpecified(serviceDto.getName(), "Service name");
        isSpecified(serviceDto.getPrice(), "Service price");

        mapper.updateEntityByDto(entity, serviceDto);

        return mapper.entityToDto(serviceDao.update(entity));
    }

    @Override
    @Transactional
    public ServiceDto getServiceById(Integer id) {
        return mapper.entityToDto(isExist(serviceDao.getById(id), "Service"));
    }


    @Override
    @Transactional
    public List<ServiceDto> getServices(ServiceSortType sortType, SortOrder sortOrder) {
        Comparator<Service> comparator = sortType.getComparator();
        List<Service> serviceList = serviceDao.getAll();
        serviceList = Sorter.sort(serviceList, comparator, sortOrder);

        return serviceList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteService(Integer id) {
        serviceDao.delete(isExist(serviceDao.getById(id), "Service"));
    }
}

