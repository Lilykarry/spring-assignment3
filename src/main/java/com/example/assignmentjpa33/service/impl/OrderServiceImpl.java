package com.example.assignmentjpa33.service.impl;

import com.example.assignmentjpa33.entity.OrderEntity;
import com.example.assignmentjpa33.repository.OrderRepository;
import com.example.assignmentjpa33.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity findByNameAndAddress(String name, String address) {
        return orderRepository.findOrderEntityByCustomerNameAndCustomerAddress(name,address);
    }

    @Override
    public void create(OrderEntity order) {
        orderRepository.save(order);
    }
}
