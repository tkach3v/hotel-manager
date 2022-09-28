package com.tkachev.controller.impl;

import com.tkachev.controller.OrderController;
import com.tkachev.dto.OrderDto;
import com.tkachev.service.OrderService;
import com.tkachev.util.sorting.sort_type.OrderSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.SortOrder;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('orders:write')")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('orders:read')")
    public OrderDto getOrderById(@PathVariable("id") Integer id) {
        return orderService.getOrderById(id);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('orders:write')")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('orders:write')")
    public String deleteOrder(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);

        return "Order with ID = " + id + " has been deleted";
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('orders:read')")
    public List<OrderDto> getOrders(@RequestParam(name = "sort-type", defaultValue = "BY_ID") OrderSortType sortType,
                                    @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder,
                                    @RequestParam(name = "user-id", required = false) Integer userId) {

        return orderService.getOrders(sortType, sortOrder, userId);
    }
}
