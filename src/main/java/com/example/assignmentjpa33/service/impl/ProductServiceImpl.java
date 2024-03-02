package com.example.assignmentjpa33.service.impl;

import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.repository.ProductRepository;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> paginationProducts(int pageNumber) {
        return productRepository.findAll(PageRequest.of(pageNumber, 5));
    }



    @Override
    public void paginationAndSortProductss(int pageNumber) {
//        Page<Product> page = productRepository.findAll(PageRequest.of(pageNumber, 5, Sort.by("unitPrice").descending()));

            Page<Product> page = productRepository.findAll(PageRequest.of(pageNumber, 5));
            List<Product> products = new ArrayList<>(page.getContent());
            products.sort(Comparator.comparing(Product::getUnitPrice).reversed());
            products.forEach(product -> {
                System.out.println(product);
            });
    }

    @Override
    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> searchByCategory(String name) {
        return productRepository.findProductByProductNameContains(name);
    }

    @Override
    public List<Product> searchByUnitPrice(double priceStart, double priceEnd) {
        return productRepository.findProductByUnitPriceBetween(priceStart,priceEnd);
    }

    @Override
    public Product searchByName(String name) {
        return productRepository.findProductByProductName(name);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findProductByProductID(id);
    }


}
