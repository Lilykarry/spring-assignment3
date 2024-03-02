package com.example.assignmentjpa33.controller;

import com.example.assignmentjpa33.domain.CartEntity;
import com.example.assignmentjpa33.domain.CartHolder;
import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RequestMapping("cart")
@Controller
public class CartController {

    @Autowired
    private CartHolder cartHolder;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showCart(Model model){
        model.addAttribute("carts",cartHolder.getCartEntities());
        return "cart/list";
    }

    @GetMapping("remove")
    public String removeCart(Model model, @RequestParam("cartItemID") String id){
        List<CartEntity> entities = cartHolder.removeItem(Integer.parseInt(id));
        model.addAttribute("carts",entities);
        return "redirect:/cart";
    }

    @GetMapping("clear")
    public String removeCart(Model model){
        List<CartEntity> entities = cartHolder.clearItem();
        model.addAttribute("carts",entities);
        return "redirect:/cart";
    }

    @PostMapping("checkout")
    public String showPopUp(Model model, @RequestParam(name = "products") List<String> products,
                            @RequestParam(name = "singleProduct", required = false) String singleProduct){

            List<CartEntity> carts = new ArrayList<>();
//            for (String prod : products) {
//                String[] parts = prod.split(",");
//                CartEntity cart = new CartEntity();
//                Product productEntity = productService.findById(Long.parseLong(parts[0]));
//                cart.setProduct(productEntity);
//                cart.setAmount(Integer.parseInt(parts[1]));
//                carts.add(cart);
//
//            }
        if (singleProduct != null) {
            products.clear();
            products.add(singleProduct);
        }

        for (String prod : products) {
            String[] parts = prod.split(",");
            CartEntity cart = new CartEntity();
            Product productEntity = productService.findById(Long.parseLong(parts[0]));
            cart.setProduct(productEntity);
            cart.setAmount(Integer.parseInt(parts[1]));
            carts.add(cart);
        }
            model.addAttribute("carts", carts);
            return "cart/checkout";

    }

    @PostMapping
    public String addToCart(Model model, @ModelAttribute Product product){
        cartHolder.addToCart(product);
        return "redirect:/product";
    }


}
