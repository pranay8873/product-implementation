package com.example.demo.service;

import com.example.demo.model.product;
import spring.product.example.model.Product;

import java.util.List;

public interface ProductService {


    void addProduct(String name, int id, String description, double price, String category, String manufacturer, String dateOfManufacture);
    Product saveProduct(Product product);
    Product getProductById(Long id);
    Product getProductByName(String name);
    List<Product> findAll();
    void deleteProduct(Long id);
    void deleteProductByName(String name);
}
