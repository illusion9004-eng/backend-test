package org.example.fruitshop.service;

import lombok.RequiredArgsConstructor;
import org.example.fruitshop.entity.Product;
import org.example.fruitshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 등록, 조회, 수정, 저장(완료), 삭제

    // 1. 과일 등록
    // 판매자, 과일명, 수량, 가격으로 등록
    // 상품 등록일
    public Product createdProduct(String userName, String proudctName, int stock, LocalDateTime createdAt){
        Product product = Product.builder()
                .userName(userName)
                .productName(proudctName)
                .stock(1)
                .price(1)
                .createdAt(LocalDateTime.now())
                .build();
        return productRepository.save(product);
    }

//    rivate String username;
//    private String productName;
//    private int stock;
//    private int price;
//    private LocalDateTime createdAt = LocalDateTime.now();




}
