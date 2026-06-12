package com.example.demo.controler;

import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import spring.product.example.model.Product;

@Controller
public class ProductControler {
   private final ProductService productService;
   public ProductControler(ProductService productService) {
       this.productService = productService;
   }
   @GetMapping("/addProduct")
   public void addProduct() {
       productService.addProduct(Product.builder().build());
   }
   @GetMapping("/saveProduct")
   public ResponseEntity<Product> saveProduct() {
       productService.saveProduct(Product.builder().build());
       return ResponseEntity.ok().build();
   }
   @GetMapping("/getProductById")
   public ResponseEntity<Product> getProductById() {
       productService.getProductById();
   }


}
