package com.spring_boot_day2.freshGoodiesAPIExercises.products.services.impl;

import com.spring_boot_day2.freshGoodiesAPIExercises.exceptions.InputException;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.repository.ProductRepository;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import jakarta.transaction.Transactional;
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

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }


    public Product addProduct(Product product) {
        product.setId(max);
        productRepository.save(product);
        max++;
        return product;
    }


    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(productRepository.findById(id).orElse(null));
    }


    public List<Product> getProductByName(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }

    public Product updateProduct(long id, Product product) {

        if (!productRepository.existsById(id)) {
            throw new InputException("Product with ID " + product.getId() + " does not exist.");
        }
        return productRepository.save(product);
//        if(productData.isPresent()){
//            var currentProduct = productData.get();
//            productRepository.save(currentProduct);
////            currentProduct.setPrice(product.getPrice());
////            currentProduct.setCategory(product.getCategory());
////            currentProduct.setName(product.getName());
////            currentProduct.setWeight(product.getWeight());
////            currentProduct.setImageUrl(product.getImageUrl());
////            currentProduct.setMetadata(product.getMetadata());
//        }
//        if(productData == null){
//            return null;
//        }
//        return productData;
    }



    @Transactional
    public Product deleteProduct(long id){


        Product tempProduct = productRepository.findById(id).orElse(null);
        if(tempProduct == null){
            throw new InputException("Product with ID " + id + " does not exist.");
        }
        var currentProduct = tempProduct;

        productRepository.deleteById(tempProduct.getId());

//        var index =  IntStream.range(0, list.size())
//                .filter(i ->list.get(i).getId() == id)
//                .findFirst().orElse(-1);
//        if(index == -1){
//            return currentProduct;
//        }
//        System.out.println(index);
//        list.remove(index);
        return currentProduct;
    }
}
