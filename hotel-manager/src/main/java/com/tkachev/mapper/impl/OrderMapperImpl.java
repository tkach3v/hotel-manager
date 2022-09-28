package com.tkachev.mapper.impl;

import com.tkachev.dto.OrderDto;
import com.tkachev.entity.Order;
import com.tkachev.mapper.OrderMapper;
import com.tkachev.mapper.ServiceMapper;
import com.tkachev.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public OrderDto entityToDto(Order entity) {
        if (entity == null) {
            return null;
        }

        OrderDto dto = new OrderDto();

        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setService(serviceMapper.entityToDto(entity.getService()));
        dto.setUser(userMapper.entityToDto(entity.getUser()));

        return dto;
    }

    @Override
    public Order dtoToEntity(OrderDto dto) {
        if (dto == null) {
            return null;
        }

        Order entity = new Order();

        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setService(serviceMapper.dtoToEntity(dto.getService()));
        entity.setUser(userMapper.dtoToEntity(dto.getUser()));

        return entity;
    }

    @Override
    public void updateEntityByDto(Order entity, OrderDto dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setDate(dto.getDate());
        entity.setService(serviceMapper.dtoToEntity(dto.getService()));
        entity.setUser(userMapper.dtoToEntity(dto.getUser()));
    }
}
