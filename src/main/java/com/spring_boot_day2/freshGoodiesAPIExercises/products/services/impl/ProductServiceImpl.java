package com.spring_boot_day2.freshGoodiesAPIExercises.products.services.impl;

import com.spring_boot_day2.freshGoodiesAPIExercises.exceptions.InputException;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@Log
public class ProductServiceImpl implements ProductService {

    public static int max = 1;
    public List<Product> list = new ArrayList<>();

    public List<Product> getProduct(){
        return this.list;
    }


    public Product addProduct(Product product) {
        product.setId(max);
        list.add(product);
        max++;
        return product;
    }


    public Optional<Product> getProductById(int id) {
        return list.stream().filter(item -> item.getId() == id).findFirst();
    }


    public List<Product> getProductByName(String name) {
        return list.stream().filter(data -> data.getName().equals(name)).collect(Collectors.toList());
    }

    public Optional<Product> updateProduct(int id, Product product) {
        var productData = list.stream().filter(data -> data.getId() == id).findFirst();
        if(productData.isPresent()){
            var currentProduct = productData.get();
            currentProduct.setPrice(product.getPrice());
            currentProduct.setCategory(product.getCategory());
            currentProduct.setName(product.getName());
            currentProduct.setWeight(product.getWeight());
            currentProduct.setImageUrl(product.getImageUrl());
            currentProduct.setMetadata(product.getMetadata());
        }
        if(productData == null){
            return null;
        }
        return productData;
    }


    public Optional<Product> deleteProduct(int id){
        var currentProduct = list.stream().filter(item -> item.getId() == id).findFirst();
        if(currentProduct.isEmpty()){
            return currentProduct;
        }
        var index =  IntStream.range(0, list.size())
                .filter(i ->list.get(i).getId() == id)
                .findFirst().orElse(-1);
        if(index == -1){
            return currentProduct;
        }
        System.out.println(index);
        list.remove(index);
        return currentProduct;
    }
}
