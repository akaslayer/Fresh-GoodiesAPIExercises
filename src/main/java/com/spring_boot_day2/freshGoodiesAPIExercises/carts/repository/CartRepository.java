package com.spring_boot_day2.freshGoodiesAPIExercises.carts.repository;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.model.Cart;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
