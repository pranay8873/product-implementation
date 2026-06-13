package com.product.project.service;

import com.product.project.entity.Product;
import com.product.project.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServ {
    ProductRepo productRepo;
    public ProductServ(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public Optional<Product> saveProduct(Product product) {
        return productRepo.saveProduct(product);
    }
    public Optional<Product> getProductById(int id) {
        return productRepo.getProductById(id);
    }
    public Optional<Product> getProductByName(String name) {
        return productRepo.getProductByName(name);
    }
    public Optional<Product> getProductByCategory(String category) {
        return productRepo.getProductByCategory(category);
    }
    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }
    public List<Product> getAllProducts() {
        return productRepo.getAllProducts();
    }
}
