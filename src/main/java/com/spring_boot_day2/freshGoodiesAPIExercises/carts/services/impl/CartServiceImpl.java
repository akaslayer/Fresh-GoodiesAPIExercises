package com.spring_boot_day2.freshGoodiesAPIExercises.carts.services.impl;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto.CartDetail;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.mapper.CartDetailMapper;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.model.Cart;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.repository.CartDetailRepository;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.repository.CartRepository;
import com.spring_boot_day2.freshGoodiesAPIExercises.carts.services.CartService;
import com.spring_boot_day2.freshGoodiesAPIExercises.exceptions.InputException;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.repository.ProductRepository;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@Service
@Log
public class CartServiceImpl implements CartService {

    public final ProductService productService;
    private final CartDetailMapper cartDetailMapper;
    private CartRepository cartRepository;
    private CartDetailRepository cartDetailRepository;




    public static int max = 1;

    private List<Cart> cartList = new ArrayList<>();


    public CartServiceImpl(ProductService productService, CartDetailMapper cartDetailMapper, CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productService = productService;
        this.cartDetailMapper = cartDetailMapper;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<CartDetail> getCart() {
        cartDetailRepository.deleteAll();
        List<Product> data = productService.getProduct();
        for(Cart list:cartRepository.findAll()){
            Optional<Product> cartData = data.stream().filter(product -> product.getId() == list.getProductId()).findFirst();
            if(cartData.isPresent()){
                Product product = cartData.get();
                CartDetail.ProductCart cartDTO = cartDetailMapper.createProductWithoutId(product);
                CartDetail currentCart = new CartDetail();
                currentCart.setProductCart(cartDTO);
                currentCart.setProductId(list.getProductId());
                currentCart.setQuantity(list.getQuantity());
                currentCart.setId(list.getId());
                cartDetailRepository.save(currentCart);

            }
//            Optional<Product> cartDetailData = data.stream().filter(product -> product.getId() == list.getProductId()).findFirst();
//            if(cartDetailData.isPresent()){
//                Product product = cartDetailData.get();
//                CartDetail.ProductCart cartDTO = cartDetailMapper.createProductWithoutId(product);
//                CartDetail currentCart = new CartDetail();
//                currentCart.setProductCart(cartDTO);
//                currentCart.setProductId(list.getProductId());
//                currentCart.setQuantity(list.getQuantity());
//                currentCart.setId(list.getId());
//                cartListDetail.add(currentCart);
//            }
        }
        return cartDetailRepository.findAll();
    }


    public Cart addCart(Cart cart) {
        List<Product> data = productService.getProduct();
        boolean exist = data.stream().anyMatch(product -> product.getId() == cart.getProductId());
        if(!exist){
            throw new InputException(HttpStatus.NOT_FOUND,"Product with ID " + cart.getProductId() + " don't exist.");
        }
        cart.setId(max);
        cartRepository.save(cart);
        max++;
        return cart;
    }


    public Cart updateCart(long id ,Cart cart) {
        if (!cartRepository.existsById(id)) {
            throw new InputException("Cart with ID " + id + " does not exist.");
        }
        return cartRepository.save(cart);
//        var cartData = cartList.stream().filter(data -> data.getId() == cart.getId()).findFirst();
//        if(cartData.isPresent()){
//            var currentCart = cartData.get();
//            currentCart.setProductId(cart.getProductId());
//            currentCart.setQuantity(cart.getQuantity());
//        }
//        if(cartData == null){
//            return null;
//        }
//        return cartData;
    }


    public Cart deleteCart(long id) {

//            var currentCart = cartList.stream().filter(item -> item.getId() == id).findFirst();
//            if(currentCart.isEmpty()){
//                return currentCart;
//            }
//            var index =  IntStream.range(0, cartList.size())
//                    .filter(i ->cartList.get(i).getId() == id)
//                    .findFirst().orElse(-1);
//            if(index == -1){
//                return currentCart;
//            }
//            System.out.println(index);
//            cartList.remove(index);
//            return currentCart;
        Cart tempCart = cartRepository.findById(id).orElse(null);
        if(tempCart == null){
            throw new InputException("Cart with ID " + id + " does not exist.");
        }
        var currentCart = tempCart;

        cartRepository.deleteById(tempCart.getId());
        return currentCart;
    }

}
