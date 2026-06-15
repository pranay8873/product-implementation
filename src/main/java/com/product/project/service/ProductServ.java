package com.product.project.service;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.Exception.ProductNotFoundExcption;
import com.product.project.entity.Product;
import com.product.project.repository.ProductReopo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServ implements ProductService {
   private final ProductReopo productRepo;


    @Override
    public Product addProduct(Product product) throws ProductExistsExcption {
        Optional<Product> product1 = productRepo.findByName(product.getName());
        if(product1.isPresent()) {
            throw new ProductExistsExcption("Product with name " + product.getName() + " already exists");
        }
        return productRepo.save(product);

    }

    @Override
    public Product getProductById(int id) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findById(id);
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with id " + id + " not found");
        }
        return product1.get();

    }
    @Override
    public Product getProductByName(String name) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findByName(name);
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with name " + name + " not found");
        }
        return product1.get();

    }
    @Override
    public List<Product> getProductByCategory(String category) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findByCategory(category);
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with category " + category + " not found");
        }
        return Collections.singletonList(product1.get());

    }
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findById(product.getId());
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with id " + product.getId() + " not found");
        }
        return productRepo.save(product);


    }

    @Override
    public boolean deleteProduct(int id) throws ProductNotFoundExcption {
        if(productRepo.findById(id).isEmpty()) {
            throw new ProductNotFoundExcption("Product with id " + id + " not found");
        }
        productRepo.deleteById(id);
        return true;

    }
}
