package com.computerAccessoriesStore.service.impl;

import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.repository.ProductRepository;
import com.computerAccessoriesStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
