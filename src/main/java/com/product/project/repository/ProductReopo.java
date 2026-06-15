package com.product.project.repository;

import com.product.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductReopo extends JpaRepository<Product, Integer> {

     Optional<Product> findByname(String name);
     Optional<Product> getbyid(int id);
     Optional<Product> findByCategory(String category);
}
