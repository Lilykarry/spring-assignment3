package com.example.assignmentjpa33.domain;

import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartHolder {
    List<CartEntity> cartEntities = new ArrayList<>();

    public List<CartEntity> getCartEntities() {
        return cartEntities;
    }

    public void setCartEntities(List<CartEntity> cartEntities) {
        this.cartEntities = cartEntities;
    }

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Product product) {
        Product prod = productRepository.findProductByProductID(product.getProductID());
        CartEntity cartEntity = cartEntities.stream()
                .filter(entity -> entity.getProduct() != null &&
                        entity.getProduct().getProductID() == product.getProductID())
                .findFirst().orElse(new CartEntity());
        if(cartEntity.getAmount() <= 0){
            cartEntity.setProduct(prod);
            cartEntity.setAmount(1);
            cartEntities.add(cartEntity);
            print();
            return;
        }
        cartEntity.setAmount(cartEntity.getAmount() + 1);
        print();
    }


    public List<CartEntity> removeItem(int id) {
        cartEntities.remove(id-1);
        return cartEntities;
    }

    public List<CartEntity> clearItem() {
        cartEntities.clear();
        return cartEntities;
    }

    private void print() {
        System.out.println("///////////////////////////");
        cartEntities.forEach(item -> {
            System.out.println("Amount: " + item.getAmount());
            System.out.println("ProductID: " + item.getProduct().getProductID());
        });
    }


}
