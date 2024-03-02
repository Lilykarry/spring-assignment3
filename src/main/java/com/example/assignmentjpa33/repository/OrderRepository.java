package com.example.assignmentjpa33.repository;

import com.example.assignmentjpa33.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    OrderEntity findOrderEntityByCustomerNameAndCustomerAddress(String name, String address);
}
