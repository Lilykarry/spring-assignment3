package com.example.assignmentjpa33.controller;

import com.example.assignmentjpa33.domain.CartEntity;
import com.example.assignmentjpa33.domain.OrderHolder;
import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.service.OrderService;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("order")
@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderHolder orderHolder;

    @PostMapping("add")
    public String addItem(Model model, @RequestParam(name = "products") List<String> products,
                           @RequestParam("name") String name,
                          @RequestParam("address") String address,
                          @RequestParam(name = "singleProduct", required = false) String singleProduct){


        orderHolder.addOrderDetail(products,name,address,singleProduct);
//        for(String prod : products){
//            String[] parts = prod.split(",");
//            Product productEntity = productService.findById(Long.parseLong(parts[0]));
//            orderHolder.addOrderDetail(productEntity,Integer.parseInt(parts[1]), name, address);
//        }
       // orderHolder.addOrder(name,address);

        System.out.println("Success");
        return "redirect:/product";
    }
}
