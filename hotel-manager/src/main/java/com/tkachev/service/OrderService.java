package com.tkachev.service;

import com.tkachev.dto.OrderDto;
import com.tkachev.util.sorting.sort_type.OrderSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface OrderService {

    OrderDto addOrder(OrderDto orderDto);

    void deleteOrder(Integer id);

    OrderDto updateOrder(OrderDto orderDto);

    List<OrderDto> getOrders(OrderSortType sortType, SortOrder sortOrder, Integer userId);

    OrderDto getOrderById(Integer id);
}
