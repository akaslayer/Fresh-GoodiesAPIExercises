package com.spring_boot_day2.freshGoodiesAPIExercises.carts.mapper;

import com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto.CartDetail;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CartDetailMapper {
    CartDetail.ProductCart userToUserDTO(Product product);

    CartDetail.ProductCart createProductWithoutId(Product product);
}
