package com.tkachev.mapper.impl;

import com.tkachev.dto.ServiceDto;
import com.tkachev.entity.Service;
import com.tkachev.mapper.ServiceMapper;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDto entityToDto(Service entity) {
        if (entity == null) {
            return null;
        }

        ServiceDto serviceDto = new ServiceDto();

        serviceDto.setId(entity.getId());
        serviceDto.setPrice(entity.getPrice());
        serviceDto.setName(entity.getName());

        return serviceDto;
    }

    @Override
    public Service dtoToEntity(ServiceDto dto) {
        if (dto == null) {
            return null;
        }

        Service entity = new Service();

        entity.setId(dto.getId());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());

        return entity;
    }

    @Override
    public void updateEntityByDto(Service entity, ServiceDto dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());
    }
}
