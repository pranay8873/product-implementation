package com.product.project.service;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.Exception.ProductNotFoundExcption;
import com.product.project.dto.ProductRequestdto;
import com.product.project.dto.ProductResponsedto;
import com.product.project.dto.ProductUpdateDto;
import com.product.project.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponsedto addProduct(ProductRequestdto product)
            throws ProductExistsExcption;

    ProductResponsedto getProductById(int id)
            throws ProductNotFoundExcption;

    ProductResponsedto getProductByName(String name)
            throws ProductNotFoundExcption;

    List<ProductResponsedto> getProductByCategory(String category)
            throws ProductNotFoundExcption;

    ProductResponsedto updateProduct(ProductUpdateDto product)
            throws ProductNotFoundExcption;

    void deleteProduct(int id)
            throws ProductNotFoundExcption;

    List<ProductResponsedto> getAllProducts();
}
