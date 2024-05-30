package com.spring_boot_day2.freshGoodiesAPIExercises.products.services;

import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getProduct();
    public Product addProduct(Product product);

    public Optional<Product> getProductById(int id);

    public List<Product> getProductByName(String name);

    public Optional<Product> updateProduct(int id, Product product);

    public Optional<Product> deleteProduct(int id);
}
