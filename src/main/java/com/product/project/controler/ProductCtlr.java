package com.product.project.controler;

import com.product.project.entity.Product;
import com.product.project.service.ProductServ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductCtlr {
    ProductServ productServ;
    public ProductCtlr(ProductServ productServ) {
        this.productServ = productServ;
    }
    @PostMapping("/add")
    public ResponseEntity<Optional<Product>> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productServ.saveProduct(product));
    }
    @RequestMapping("/get/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productServ.getProductById(id));
    }
    @RequestMapping("/getByName")
    public ResponseEntity<Optional<Product>> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(productServ.getProductByName(name));
    }
    @RequestMapping("/getByCategory")
    public ResponseEntity<Optional<Product>> getProductByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productServ.getProductByCategory(category));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServ.deleteProduct(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productServ.getAllProducts());
    }
    @PutMapping("/update")
    public ResponseEntity<Optional<Product>> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productServ.saveProduct(product));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Product>> updateProductById(@PathVariable int id, @RequestBody  Product product) {
        return ResponseEntity.ok(productServ.saveProduct(product));
    }
}
