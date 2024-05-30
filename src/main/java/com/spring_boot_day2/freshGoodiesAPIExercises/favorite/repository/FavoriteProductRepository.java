package com.spring_boot_day2.freshGoodiesAPIExercises.favorite.repository;

import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct,Long> {
}
