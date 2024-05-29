package com.spring_boot_day2.freshGoodiesAPIExercises.products.services;

import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProduct();
    public Product addProduct(Product product);
}
