package com.tkachev.mapper;


import com.tkachev.dto.OrderDto;
import com.tkachev.entity.Order;

public interface OrderMapper {

    OrderDto entityToDto(Order entity);

    Order dtoToEntity(OrderDto dto);

    void updateEntityByDto(Order entity, OrderDto dto);
}
