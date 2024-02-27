package com.example.assignmentjpa33.service;

import com.example.assignmentjpa33.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> productList();
    Page<Product> paginationProducts(int pageNumber);
    void paginationAndSortProductss(int pageNumber);
    void insertProduct(Product product);
    List<Product> searchByCategory(String name);
    List<Product> searchByUnitPrice(double priceStart,double priceEnd);
    Product searchByName(String name);
}
