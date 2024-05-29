package com.spring_boot_day2.freshGoodiesAPIExercises.products;

import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getProduct());
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }
}
