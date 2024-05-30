package com.spring_boot_day2.freshGoodiesAPIExercises.carts.repository;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}
