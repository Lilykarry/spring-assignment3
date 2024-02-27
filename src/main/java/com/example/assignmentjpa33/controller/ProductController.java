package com.example.assignmentjpa33.controller;

import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProduct(Model model){
        List<Product> products = productService.productList();
        model.addAttribute("products", products);
        String b = "hello Ly";
        model.addAttribute("greet",b);
        return "product/list";
    }
}
