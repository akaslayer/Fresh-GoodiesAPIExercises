package com.spring_boot_day2.freshGoodiesAPIExercises.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id" )
    private Metadata metadata;

}





