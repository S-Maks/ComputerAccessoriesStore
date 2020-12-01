package com.computerAccessoriesStore.service;

import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.models.User;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
