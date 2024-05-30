package com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="favoriteProduct")
public class FavoriteProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="userId")
    @Positive
    private long userId;

    @NotNull
    @Column(name="productId")
    private long productId;
}
