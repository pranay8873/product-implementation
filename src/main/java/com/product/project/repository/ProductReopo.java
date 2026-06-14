package com.product.project.repository;

import com.product.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReopo extends JpaRepository<Product, Integer> {
}
