package com.example.motorider.repository;


import com.example.motorider.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByOrderByCreatedDateTime();


    List<Product> findAllByQuantityGreaterThan(int quantity);
}
