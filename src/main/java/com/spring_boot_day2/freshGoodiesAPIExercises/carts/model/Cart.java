package com.spring_boot_day2.freshGoodiesAPIExercises.carts.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NonNull
    @Column(name="productId")
    private long productId;

    @NonNull
    @NotBlank(message = "Quantity is required")
    @Column(name="quantity")
    private int quantity;

}
