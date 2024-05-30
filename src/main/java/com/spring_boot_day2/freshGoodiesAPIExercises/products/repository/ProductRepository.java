package com.spring_boot_day2.freshGoodiesAPIExercises.products.repository;

import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    public List<Product> findByNameIgnoreCaseContaining(String name);
    @Query(value = "DELETE from product p WHERE p.id=?1",nativeQuery = true)
    public void deleteProductById(Long id);


}
