package com.spring_boot_day2.freshGoodiesAPIExercises.products.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private long id;

    @NonNull
    @NotBlank(message = "Product name is required")
    private String name;

    @NonNull
    @NotBlank(message = "Category name is required")
    private String category;

    @NonNull
    @NotBlank(message = "name is required")
    private String imageUrl;

    @Min(value = 0, message="Price must be non-negative")
    private double price;

    @Min(value = 0, message="weight must be non-negative")
    private double weight;

    @NotNull(message = "Metadata is required")
    private Metadata metadata;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metadata{
        @NotBlank(message = "Unit is required")
        private String unit;

        @Min(value = 0, message = "Weight must be non-negative")
        private int weight;

        @Min(value = 0, message = "Calorie count must be non-negative")
        private int calorie;

        @Min(value = 0, message = "Proteins must be non-negative")
        private double proteins;

        @Min(value = 0, message = "Fats must be non-negative")
        private double fats;

        @Min(value = 0, message = "Increment must be non-negative")
        private int increment;

        @Min(value = 0, message = "Carbs must be non-negative")
        private int carbs;
    }
}




