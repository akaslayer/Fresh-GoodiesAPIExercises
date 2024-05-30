package com.spring_boot_day2.freshGoodiesAPIExercises.products;

import com.spring_boot_day2.freshGoodiesAPIExercises.exceptions.InputException;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import com.spring_boot_day2.freshGoodiesAPIExercises.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }




    @PostMapping("")
    public ResponseEntity<Response<Product>> addNewProduct(@Valid @RequestBody Product product){
        return Response.successfulResponse(HttpStatus.CREATED.value(),"Product has been created",productService.addProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Product>>> getProductById(@PathVariable("id") int id){
        Optional<Product> data = productService.getProductById(id);
        if(data.isPresent()){
            return Response.successfulResponse("Product fetched",data);
        }
      return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Product not found",data);
    }

    @GetMapping("")
    public ResponseEntity<Response<List<Product>>> getProductByName(@RequestParam("name") String name){
        if (name.isEmpty()){
            return Response.successfulResponse("All products fetched",productService.getProduct());
        }
        return Response.successfulResponse("All products by name is fetched",productService.getProductByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Product>> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        product.setId(id);
        Product data = productService.updateProduct(id,product);
//        if(data.isPresent()){
            return Response.successfulResponse("Product has been updated",productService.updateProduct(id,product));
//        }
//        return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Product not found",data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Product>> deleteProduct(@PathVariable("id") long id){
        return Response.successfulResponse("Product has been deleted",productService.deleteProduct(id));

//        return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Product not found",data);
    }
}
