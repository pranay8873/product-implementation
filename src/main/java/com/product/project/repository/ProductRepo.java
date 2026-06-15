//package com.product.project.repository;
//
//import com.product.project.Exception.ProductExistsExcption;
//import com.product.project.Exception.ProductNotFoundExcption;
//import com.product.project.entity.Product;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//public class ProductRepo{
//    Product product;
//    private final List<Product> products;
//
//    public ProductRepo() {
//
//        this.products = new ArrayList<>();
//    }
//    public ProductRepo(List<Product> products) {
//        this.products = products;
//    }
//    public Optional<Product> saveProduct(Product product) {
//        if(this.products.stream().anyMatch(p -> p.getId() == product.getId())) {
//            throw new ProductExistsExcption("Product with id " + product.getId() + " already exists");
//        }
//        this.products.add(product);
//        return Optional.of(product);
//    }
//    public List<Product> getAllProducts() {
//        return this.products;
//    }
//    public Optional<Product> getProductById(int id) {
//        return Optional.of(this.products.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(() -> new ProductNotFoundExcption("Product with id " + id + " not found")));
//    }
//    public Optional<Product> getProductByName(String name) {
//        return Optional.of(this.products.stream().filter(product -> product.getName().equals(name)).findFirst().orElseThrow(() -> new ProductExistsExcption("Product with name " + name + " not found")));
//    }
//    public Optional<Product> getProductByCategory(String category) {
//        return Optional.of(this.products.stream().filter(product -> product.getCategory().equals(category)).findFirst().orElseThrow(() -> new ProductExistsExcption("Product with category " + category + " not found")));
//    }
//    public void deleteProduct(int id) {
//        this.products.removeIf(product -> product.getId() == id);
//    }
//

//}
