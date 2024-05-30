package com.spring_boot_day2.freshGoodiesAPIExercises.carts.dto;



import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Metadata;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="cartDetail")
public class CartDetail {

    @Id
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="quantity")
    private int quantity;


    @NotNull(message = "Product is required")
    private  ProductCart productCart;

    @NonNull
    @Column(name="productId")
    private long productId;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ProductCart {
        @NonNull
        @NotBlank(message = "Product name is required")
        @Column(name="name")
        private String name;

        @NonNull
        @NotBlank(message = "Category name is required")
        @Column(name="category")
        private String category;

        @NonNull
        @NotBlank(message = "name is required")
        @Column(name="imageUrl")
        private String imageUrl;

        @Min(value = 0, message="Price must be non-negative")
        @Column(name="price")
        private double price;

        @Min(value = 0, message="weight must be non-negative")
        @Column(name="weight")
        private double weight;

        @NotNull(message = "Metadata is required")
        private Metadata metadata;
    }


    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metadata{
        @NotBlank(message = "Unit is required")
        @Column(name="unit")
        private String unit;

        @Min(value = 0, message = "Weight must be non-negative")
        @Column(name="weightMetadata")
        private int weight;

        @Min(value = 0, message = "Calorie count must be non-negative")
        @Column(name="calorie")
        private int calorie;

        @Min(value = 0, message = "Proteins must be non-negative")
        @Column(name="proteins")
        private double proteins;

        @Min(value = 0, message = "Fats must be non-negative")
        @Column(name="fats")
        private double fats;

        @Min(value = 0, message = "Increment must be non-negative")
        @Column(name="increment")
        private int increment;

        @Min(value = 0, message = "Carbs must be non-negative")
        @Column(name="carbs")
        private int carbs;
    }
}
