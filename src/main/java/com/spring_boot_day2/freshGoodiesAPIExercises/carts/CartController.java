package com.spring_boot_day2.freshGoodiesAPIExercises.carts;


import com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto.CartDetail;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.model.Cart;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.services.CartService;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")

public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("")
    public ResponseEntity<Response<Cart>> addNewCart(@RequestBody Cart cart){
        return Response.successfulResponse(HttpStatus.CREATED.value(),"Cart has been created",cartService.addCart(cart));
    }

    @GetMapping("")
    public ResponseEntity<Response<List<CartDetail>>> getCart(){
        List<CartDetail> data = cartService.getCart();

        if(data.isEmpty()){
            return Response.successfulResponse("Cart is empty",cartService.getCart());
        }
        return Response.successfulResponse("Cart fetched",cartService.getCart());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Optional<Cart>>> updateCart(@RequestBody Cart cart){
        Optional<Cart> data = cartService.updateCart(cart);
        if(data.isPresent()){
            return Response.successfulResponse("Cart has been updated",data);
        }
        return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Cart not found",data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Optional<Cart>>> deleteCart(@PathVariable("id") int id){
        Optional<Cart> data = cartService.deleteCart(id);
        if(data.isPresent()){
            return Response.successfulResponse("Cart has been deleted",data);
        }
        return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Cart not found",data);
    }
}
