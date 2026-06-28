package org.example.fruitshop.service;

import lombok.RequiredArgsConstructor;
import org.example.fruitshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;




}
