package com.spring_boot_day2.freshGoodiesAPIExercises.favorite.services;

import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model.FavoriteProduct;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;

import java.util.List;

public interface FavoriteProductServices {

    public String toogleFavorite(FavoriteProduct favoriteProduct);
    public List<FavoriteProduct> getFavoriteList(int userId);
}
