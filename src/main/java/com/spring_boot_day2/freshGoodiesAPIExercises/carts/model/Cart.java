package com.spring_boot_day2.freshGoodiesAPIExercises.carts.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cart {
    private long id;

    @NonNull
    @NotBlank(message = "Product id is required")
    private long productId;

    @NonNull
    @NotBlank(message = "Quantity is required")
    private int quantity;

}
