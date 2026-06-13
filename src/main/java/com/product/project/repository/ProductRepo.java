package com.product.project.repository;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepo {
    Product product;
    private List<Product> products;

    public ProductRepo() {
        this.product = new Product();
    }
    public ProductRepo(List<Product> products) {
        this.products = products;
    }
    void saveProduct(Product product) {
        if(this.products.stream().anyMatch(p -> p.getId() == product.getId())) {
            throw new ProductExistsExcption("Product with id " + product.getId() + " already exists");
        }
        this.products.add(product);
    }
    List<Product> getAllProducts() {
        return this.products;
    }
    Optional<Product> getProductById(int id) {
        return this.products.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(() -> new ProductExistsExcption("Product with id " + id + " not found"));
    }
    Optional<Product> getProductByName(String name) {
        return this.products.stream().filter(product -> product.getName().equals(name)).findFirst().orElseThrow(() -> new ProductExistsExcption("Product with name " + name + " not found"));
    }
    Optional<Product> getProductByCategory(String category) {
        return this.products.stream().filter(product -> product.getCategory().equals(category)).findFirst().orElseThrow(() -> new ProductExistsExcption("Product with category " + category + " not found"));
    }
    void deleteProduct(int id) {
        this.products.removeIf(product -> product.getId() == id);
    }

}
