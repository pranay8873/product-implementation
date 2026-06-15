package com.product.project.controler;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.entity.Product;
import com.product.project.service.ProductServ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCtlr {
    private final ProductServ productServ;

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws ProductExistsExcption {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServ.addProduct(product));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productServ.getProductById(id));
    }
    @GetMapping("/getByName")
    public ResponseEntity<Optional<Product>> getProductByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(productServ.getProductByName(name)));
    }
    @GetMapping("/getByCategory")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam String category) {
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
        return ResponseEntity.ok(Optional.ofNullable(productServ.updateProduct(product)));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(
            @PathVariable int id,
            @RequestBody Product product) {

        product.setId(id);
        return ResponseEntity.ok(
                productServ.updateProduct(product)
        );
    }
}
