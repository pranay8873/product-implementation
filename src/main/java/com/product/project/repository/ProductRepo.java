package com.product.project.repository;

import java.util.List;

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
        this.products.add(product);
    }
    List<Product> getAllProducts() {
        return this.products;
    }
    Product getProductById(int id) {
        return this.products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}
