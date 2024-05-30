package com.spring_boot_day2.freshGoodiesAPIExercises.products.model;


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
@Table(name="metadata")
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

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
