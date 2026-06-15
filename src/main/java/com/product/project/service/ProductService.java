package com.product.project.service;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.Exception.ProductNotFoundExcption;
import com.product.project.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product) throws ProductExistsExcption;

    Product getProductById(int id) throws ProductNotFoundExcption;
    Product getProductByName(String name) throws ProductNotFoundExcption;
    List<Product> getProductByCategory(String category) throws ProductNotFoundExcption;

    Product updateProduct(Product product) throws ProductNotFoundExcption;

    boolean deleteProduct(int id) throws ProductNotFoundExcption;
    List<Product> getAllProducts();
}
