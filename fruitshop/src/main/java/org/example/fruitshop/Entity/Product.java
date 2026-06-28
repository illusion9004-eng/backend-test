package org.example.fruitshop.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Product_List")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private int price;
    private LocalDateTime createdAt = LocalDateTime.now();
}
