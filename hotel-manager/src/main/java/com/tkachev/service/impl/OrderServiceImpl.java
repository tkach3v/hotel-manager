package com.tkachev.service.impl;

import com.tkachev.dao.UserDao;
import com.tkachev.dao.OrderDao;
import com.tkachev.dao.ServiceDao;
import com.tkachev.dto.OrderDto;
import com.tkachev.entity.Order;
import com.tkachev.mapper.OrderMapper;
import com.tkachev.service.AbstractService;
import com.tkachev.service.OrderService;
import com.tkachev.util.sorting.Sorter;
import com.tkachev.util.sorting.sort_type.OrderSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.List;

@org.springframework.stereotype.Service
public class OrderServiceImpl extends AbstractService implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private OrderMapper mapper;

    @Override
    @Transactional
    public OrderDto addOrder(OrderDto orderDto) {
        isSpecified(orderDto.getUser(), "User");
        isSpecified(orderDto.getService(), "Service");
        isSpecified(orderDto.getDate(), "Date");
        isExist(userDao.getById(orderDto.getUser().getId()), "User");
        isExist(serviceDao.getById(orderDto.getService().getId()), "Service");

        return mapper.entityToDto(orderDao.add(mapper.dtoToEntity(orderDto)));
    }

    @Override
    @Transactional
    public void deleteOrder(Integer id) {
        orderDao.delete(isExist(orderDao.getById(id), "Order"));
    }

    @Override
    @Transactional
    public OrderDto updateOrder(OrderDto orderDto) {
        Order entity = isExist(orderDao.getById(orderDto.getId()), "Order");

        isSpecified(orderDto.getUser(), "User");
        isSpecified(orderDto.getService(), "Service");
        isSpecified(orderDto.getDate(), "Date");
        isExist(userDao.getById(orderDto.getUser().getId()), "User");
        isExist(serviceDao.getById(orderDto.getService().getId()), "Service");

        mapper.updateEntityByDto(entity, orderDto);

        return mapper.entityToDto(orderDao.update(entity));
    }

    @Override
    @Transactional
    public List<OrderDto> getOrders(OrderSortType sortType, SortOrder sortOrder, Integer userId) {
        Comparator<Order> comparator = sortType.getComparator();
        List<Order> orderList = getOrders(userId);
        orderList = Sorter.sort(orderList, comparator, sortOrder);

        return orderList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    private List<Order> getOrders(Integer userId) {
        List<Order> orderList;

        if (userId == null) {
            orderList = orderDao.getAll();
        } else {
            isExist(userDao.getById(userId), "User");

            orderList = orderDao.getAll()
                    .stream()
                    .filter(i -> i.getUser().getId().equals(userId))
                    .toList();
        }

        return orderList;
    }

    @Override
    @Transactional
    public OrderDto getOrderById(Integer id) {
        return mapper.entityToDto(isExist(orderDao.getById(id), "Order"));
    }
}
