package org.example.fruitshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Product_List")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 50)
    private String userName;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private int price;
    private LocalDateTime createdAt = LocalDateTime.now();
}
