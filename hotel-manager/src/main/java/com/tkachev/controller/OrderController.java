package com.tkachev.controller;

import com.tkachev.dto.OrderDto;
import com.tkachev.util.sorting.sort_type.OrderSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface OrderController {

    OrderDto addOrder(OrderDto orderDto);

    OrderDto getOrderById(Integer id);

    OrderDto updateOrder(OrderDto orderDto);

    String deleteOrder(Integer id);

    List<OrderDto> getOrders(OrderSortType sortType, SortOrder sortOrder, Integer userId);
}
