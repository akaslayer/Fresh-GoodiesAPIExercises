package com.spring_boot_day2.freshGoodiesAPIExercises.carts.services;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto.CartDetail;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.model.Cart;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public List<CartDetail> getCart();
    public Cart addCart(Cart cart);
    public Optional<Cart> updateCart(Cart cart);

    public Optional<Cart> deleteCart(int id);


}
