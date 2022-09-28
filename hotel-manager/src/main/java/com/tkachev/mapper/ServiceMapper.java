package com.tkachev.mapper;

import com.tkachev.dto.ServiceDto;
import com.tkachev.entity.Service;

public interface ServiceMapper {

    ServiceDto entityToDto(Service entity);

    Service dtoToEntity(ServiceDto dto);

    void updateEntityByDto(Service entity, ServiceDto dto);
}
