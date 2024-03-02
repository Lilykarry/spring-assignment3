package com.example.assignmentjpa33.repository;

import com.example.assignmentjpa33.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
