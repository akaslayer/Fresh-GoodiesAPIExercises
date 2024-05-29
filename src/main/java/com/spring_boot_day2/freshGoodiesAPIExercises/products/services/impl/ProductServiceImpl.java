package com.spring_boot_day2.freshGoodiesAPIExercises.products.services.impl;

import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Log
public class ProductServiceImpl implements ProductService {

    public static int max = 1;
    private final List<Product> list = new ArrayList<>();

    public List<Product> getProduct(){
        return this.list;
    }


    public Product addProduct(Product product) {
        boolean exist = list.stream().anyMatch(item -> item.getId() == product.getId());
        product.setId(max);
//        if(exist){
//            throw new InputException
//        }
        list.add(product);
        max++;
        return product;
    }
}
