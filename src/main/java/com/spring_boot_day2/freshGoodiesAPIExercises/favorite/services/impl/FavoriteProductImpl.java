package com.spring_boot_day2.freshGoodiesAPIExercises.favorite.services.impl;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.model.Cart;
import com.spring_boot_day2.freshGoodiesAPIExercises.exceptions.InputException;
import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model.FavoriteProduct;
import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.repository.FavoriteProductRepository;
import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.services.FavoriteProductServices;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@Log
public class FavoriteProductImpl implements FavoriteProductServices {
    private  List<FavoriteProduct> favoriteList = new ArrayList<>();

    public final ProductService productService;

    private FavoriteProductRepository favoriteProductRepository;

    public FavoriteProductImpl(ProductService productService, FavoriteProductRepository favoriteProductRepository) {
        this.productService = productService;
        this.favoriteProductRepository = favoriteProductRepository;
    }

    public List<FavoriteProduct> getFavoriteList(int userId){
        return favoriteProductRepository.findAll().stream().filter(data -> data.getUserId() == userId).collect(Collectors.toList());
    }

    public String toogleFavorite(FavoriteProduct favoriteProduct) {
        List<Product> data = productService.getProduct();
        boolean exist = data.stream().anyMatch(product -> product.getId() == favoriteProduct.getProductId());
        if(!exist){
            throw new InputException(HttpStatus.NOT_FOUND,"Product with ID " + favoriteProduct.getProductId() + " don't exist.");
        }
        boolean favorite = favoriteProductRepository.findAll().stream().anyMatch(product -> product.getProductId() == favoriteProduct.getProductId() && product.getUserId() == favoriteProduct.getUserId());

        if(favorite){
//            var index =  IntStream.range(0, favoriteList.size())
//                    .filter(i ->favoriteList.get(i).getUserId() == favoriteProduct.getUserId() && favoriteList.get(i).getProductId() == favoriteProduct.getProductId())
//                    .findFirst().orElse(-1);

            Optional<FavoriteProduct> favoriteData = favoriteProductRepository.findAll().stream().filter(product -> product.getProductId() == favoriteProduct.getProductId() && product.getUserId() == favoriteProduct.getUserId()).findFirst();
            favoriteProductRepository.deleteById(favoriteData.get().getId());
            return "Delete";

        }else{
            favoriteProductRepository.save(favoriteProduct);
            return "add";
        }
    }
}
