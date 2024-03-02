package com.example.assignmentjpa33.domain;

import com.example.assignmentjpa33.entity.OrderDetail;
import com.example.assignmentjpa33.entity.OrderEntity;
import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.repository.OrderDetailRepository;
import com.example.assignmentjpa33.repository.OrderRepository;
import com.example.assignmentjpa33.service.OrderService;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderHolder {
    private OrderEntity orderEntity = new OrderEntity();

    private CartHolder cartHolder = new CartHolder();
    List<OrderDetail> details = new ArrayList<>();

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository detailRepository;

    public void addOrderDetail(List<String> products,String name, String address,String singleProduct){
        OrderEntity order = orderService.findByNameAndAddress(name,address);
        if(order == null){
            orderEntity.setOrderDate(LocalDateTime.now());
            orderEntity.setCustomerAddress(address);
            orderEntity.setCustomerName(name);
            if (singleProduct != null) {
                products.clear();
                products.add(singleProduct);
            }
            for(String prod : products){
                String[] parts = prod.split(",");
                Product productEntity = productService.findById(Long.parseLong(parts[0]));
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct1(productEntity);
                orderDetail.setQuantity(Integer.parseInt(parts[1]));
                details.add(orderDetail);
            }

            orderEntity.setOrderDetail(details);
            orderService.create(orderEntity);
            for(OrderDetail detail : details){
                detail.setOrder1(orderEntity);
                detailRepository.save(detail);
            }
            return;
        }else {
            for(String prod : products){
                String[] parts = prod.split(",");
                Product productEntity = productService.findById(Long.parseLong(parts[0]));
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct1(productEntity);
                orderDetail.setQuantity(Integer.parseInt(parts[1]));
                details.add(orderDetail);
                order.setOrderDetail(details);
            }
            for(OrderDetail detail : details){
                detail.setOrder1(order);
                detailRepository.save(detail);
            }
            return;
        }


    }

    public void print() {
        Optional.ofNullable(orderEntity.getOrderDetail())
                .orElse(new ArrayList<>())
                .forEach(item -> {
                    System.out.println("ProductId: " + item.getOrder1().getCustomerName());
                    System.out.println("Quantity: " + item.getOrder1().getCustomerAddress());
                    System.out.println("===========");
                });
    }
}
