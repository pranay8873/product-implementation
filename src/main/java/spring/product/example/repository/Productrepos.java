package spring.product.example.repository;

import spring.product.example.model.Product;

import java.util.Optional;

@Repository
public interface Productrepos extends JpaRepository<Product, Long> {
}
