package com.example.demo.controler;

import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductControler {
    private final ProductService productService;
    public ProductControler(ProductService productService) {
        this.productService = productService;
    }
    public void addProduct(String name, int id, String description, double price, String category, String manufacturer, String dateOfManufacture) {
        productService.addProduct(name, id, description, price, category, manufacturer, dateOfManufacture);
    }
    public void updateProduct(int id, String name, String description, double price, String category, String manufacturer, String dateOfManufacture) {
        productService.updateProduct(id, name, description, price, category, manufacturer, dateOfManufacture);
    }
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }
    public void getProductById(int id) {
        productService.getProductById(id);
    }
    public void getProductByName(String name) {
        productService.getProductByName(name);
    }
    public void findAll() {
        productService.findAll();
    }
    public void deleteProductByName(String name) {
        productService.deleteProductByName(name);
    }



}
