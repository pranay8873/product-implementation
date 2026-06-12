package com.example.demo.service;

import com.example.demo.exception.ProductExistsException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProductSevImplementation implements Productserv {
    private final productrepo productrepo;
    public ProductSevImplementation(productrepo productrepo) {
        this.productrepo = productrepo;
    }
    public void addProduct(String name, int id, String description, double price, String category, String manufacturer, String dateOfManufacture) {
        product product = new product(name, id, description, price, category, manufacturer, dateOfManufacture);
        addProduct(product);
    }
    public Optional<product> addProduct(product product) {
        if(productrepo.getProductByName(product.getName()).isPresent()) {
            throw new ProductExistsException("Product already exists");
        }
        return productrepo.save(product);
    }
    public Optional<product> getProductById(int id) {
        if(!productrepo.getProductById(id).isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        return productrepo.getProductById(id);
    }
    public Optional<product> getProductByName(String name) {
        if(!productrepo.getProductByName(name).isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        return productrepo.getProductByName(name);
    }
    public Optional<product> updateProduct(product updatedProduct) {
        if (!productrepo.getProductById(updatedProduct.getId()).isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        return productrepo.save(updatedProduct);
    }
    public void deleteProduct(int id) {
        productrepo.deleteProduct(id);
    }
    public void deleteProductByName(String name) {
        productrepo.deleteProductByName(name);
    }
    public List<product> findAll() {
        return productrepo.findAll();
    }
}
