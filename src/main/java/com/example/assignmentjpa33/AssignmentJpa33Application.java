package com.example.assignmentjpa33;

import com.example.assignmentjpa33.config.Config;
import com.example.assignmentjpa33.entity.Product;
import com.example.assignmentjpa33.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class AssignmentJpa33Application {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentJpa33Application.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        ProductService service = context.getBean("productService", ProductService.class);
//        Scanner sc = new Scanner(System.in);

//        service.paginationProducts().forEach(product -> {
//            System.out.println(product.toString());
//        });
//        for(int i = 0; i < 15; i++){
//            Product product = new Product();
//            product.setProductDescription("good laptop"+ i);
//            product.setProductName("laptop Dell"+i);
//            product.setUnitPrice(400 + i);
//            service.insertProduct(product);
//        }


//        System.out.println("Please input page number:");
//        int pageNumber = sc.nextInt();
//        int pageNumber = 1;
//        System.out.println("PHan trang");
//        for(int i = 0; i < service.paginationProducts(pageNumber).getTotalPages(); i++){
//            System.out.println("Trang"+ i);
//            service.paginationProducts(i).forEach(product -> {
//                System.out.println(product.toString());
//            });
//        }
//        System.out.println("PHan trang va sap xep giam dan");
//        for(int i = 0; i < service.paginationProducts(pageNumber).getTotalPages(); i++){
//            System.out.println("Trang"+ i);
//            service.paginationAndSortProductss(i);
//        }
//
        //System.out.println("In ra số lượng product ở page hiện tại: " + service.paginationProducts(pageNumber).getSize());
//        System.out.println("In ra tổng số lượng product: " + service.paginationProducts(pageNumber).getTotalElements());
//        System.out.println("In ra tổng số page: " + service.paginationProducts(pageNumber).getTotalPages());

//        System.out.println("Please input category: ");
//        String name = sc.nextLine();
//        service.searchByCategory(name).forEach(products -> {
//            System.out.println(products.toString());
//        });

//        System.out.println("Please input your initial price: ");
//        double initialPrice = sc.nextDouble();
//        System.out.println("Please input your closing price:");
//        double closingPrice = sc.nextDouble();
//        service.searchByUnitPrice(initialPrice,closingPrice).forEach(product -> {
//            System.out.println(product.toString());
//        });

//        System.out.println("Please input name of product: ");
//        String productName = sc.nextLine();
//        System.out.println(service.searchByName(productName).toString());
    }

}
