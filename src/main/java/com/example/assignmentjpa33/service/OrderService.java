package com.example.assignmentjpa33.service;

import com.example.assignmentjpa33.entity.OrderEntity;

public interface OrderService {
    OrderEntity findByNameAndAddress(String name,String address);
    void create(OrderEntity order);
}
