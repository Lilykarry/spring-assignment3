package com.example.assignmentjpa33.controller;

import com.example.assignmentjpa33.domain.CartHolder;
import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("cart")
@Controller
public class CartController {

    @Autowired
    private CartHolder cartHolder;

    @Autowired
    private ProductService productService;

//    @GetMapping
//    public String showCart(Model model){
//        model.addAttribute("carts",cartHolder);
//        return "cart/list";
//    }

    @PostMapping
    public String addToCart(Model model, @ModelAttribute Product product){
        cartHolder.addToCart(product);

        List<Product> products = productService.productList();
        model.addAttribute("products",products);
        return "product/list";
        //return "redirect:/cart"
    }


}
