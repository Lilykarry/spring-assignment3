package com.example.assignmentjpa33.repository;

import com.example.assignmentjpa33.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> findAllByUnitPrice(double price, Pageable pageable);
    List<Product> findProductByProductNameContains(String name);
    List<Product> findProductByUnitPriceBetween(double priceStart, double priceEnd);
    Product findProductByProductName(String name);
    Product findProductByProductID(Long id);
}
