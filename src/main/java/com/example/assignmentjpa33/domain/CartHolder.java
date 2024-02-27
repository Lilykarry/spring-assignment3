package com.example.assignmentjpa33.domain;

import com.example.assignmentjpa33.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartHolder {
    List<CartEntity> cartEntities = new ArrayList<>();

    public List<CartEntity> getCartEntities() {
        return cartEntities;
    }

    public void addToCart(Product product) {
        CartEntity cartEntity = cartEntities.stream()
                .filter(entity -> entity.getProduct() != null &&
                        entity.getProduct().getProductID() == product.getProductID())
                .findFirst().orElse(new CartEntity());
        if(cartEntity.getAmount() <= 0){
            cartEntity.setProduct(product);
            cartEntity.setAmount(1);
            cartEntities.add(cartEntity);
            print();
            return;
        }
        cartEntity.setAmount(cartEntity.getAmount() + 1);
        print();
    }

    private void print() {
        cartEntities.forEach(item -> {
            System.out.println("Amount: " + item.getAmount());
            System.out.println("ProductID: " + item.getProduct().getProductID());
        });
    }
}
