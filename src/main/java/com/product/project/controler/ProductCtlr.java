package com.product.project.controler;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.dto.ProductRequestdto;
import com.product.project.dto.ProductResponsedto;
import com.product.project.dto.ProductUpdateDto;
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
    public ResponseEntity<ProductResponsedto> saveProduct(@RequestBody ProductRequestdto product) throws ProductExistsExcption {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServ.addProduct(product));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponsedto> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productServ.getProductById(id));
    }
    @GetMapping("/getByName")
    public ResponseEntity<ProductResponsedto> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(productServ.getProductByName(name));
    }
    @GetMapping("/getByCategory")
    public ResponseEntity<List<ProductResponsedto>> getProductByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productServ.getProductByCategory(category));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServ.deleteProduct(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponsedto>> getAllProducts() {
        return ResponseEntity.ok(productServ.getAllProducts());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponsedto> updateProductById(
            @PathVariable int id,
            @RequestBody ProductUpdateDto product) {

        product.setId(id);
        return ResponseEntity.ok(
                productServ.updateProduct(product)
        );
    }
}
