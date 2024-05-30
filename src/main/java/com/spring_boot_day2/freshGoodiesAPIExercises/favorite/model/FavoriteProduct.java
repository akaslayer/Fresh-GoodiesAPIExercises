package com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FavoriteProduct {

    @NotNull
    @Positive
    private int userId;

    @NotNull
    @Positive(message = "Product id is required")
    private int productId;
}
