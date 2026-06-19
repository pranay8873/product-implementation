package com.product.project.service;

import com.product.project.Exception.ProductExistsExcption;
import com.product.project.Exception.ProductNotFoundExcption;
import com.product.project.dto.ProductRequestdto;
import com.product.project.dto.ProductResponsedto;
import com.product.project.dto.ProductUpdateDto;
import com.product.project.entity.Address;
import com.product.project.entity.Product;
import com.product.project.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServ implements ProductService {
   private final ProductRepo productRepo;
   private final ModelMapper modelMapper;


    @Override
    public ProductResponsedto addProduct(ProductRequestdto product) {

        Product productentity = modelMapper.map(product, Product.class);

        Address address = modelMapper.map(
                product.getManfactured_address(),
                Address.class
        );

        address.setProduct(productentity);
        productentity.setManfactured_address(address);

        Product savedProduct = productRepo.save(productentity);

        return modelMapper.map(savedProduct, ProductResponsedto.class);
    }

    @Override
    public ProductResponsedto getProductById(int id) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findById(id);
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with id " + id + " not found");
        }
        return modelMapper.map(product1.get(),ProductResponsedto.class);

    }
    @Override
    public ProductResponsedto getProductByName(String name) throws ProductNotFoundExcption {
        Optional<Product> product1 = productRepo.findByName(name);
        if(product1.isEmpty()) {
            throw new ProductNotFoundExcption("Product with name " + name + " not found");
        }
        return modelMapper.map(product1.get(),ProductResponsedto.class);

    }
    @Override
    public List<ProductResponsedto> getProductByCategory(String category) throws ProductNotFoundExcption {
        List<Product> products = productRepo.findByCategory(category);

        if(products.isEmpty()) {
            throw new ProductNotFoundExcption(
                    "No products found in category " + category
            );
        }

        return products.stream()
                .map(product -> modelMapper.map(product,
                        ProductResponsedto.class))
                .toList();
    }

    @Override
    public ProductResponsedto updateProduct(ProductUpdateDto product) throws ProductNotFoundExcption {
        Product product1=productRepo.findById(product.getId()).orElseThrow(() -> new ProductNotFoundExcption("Product with id " + product.getId() + " not found"));
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setImage(product.getImage());
        product1.setQuantity(product.getQuantity());
        product1.setDiscount(product.getDiscount());
        product1.setType(product.getType());
        product1.setStatus(product.getStatus());
        product1.setManfactured_address(modelMapper.map(
                product.getManfactured_address(),
                Address.class
        ));
        return modelMapper.map(productRepo.save(product1),ProductResponsedto.class);
    }

    @Override
    public List<ProductResponsedto> getAllProducts() {
        return productRepo.findAll().stream()
                .map(product -> modelMapper.map(product, ProductResponsedto.class))
                .collect(Collectors.toList());
    }



    @Override
    public void deleteProduct(int id) throws ProductNotFoundExcption {
        if(productRepo.findById(id).isEmpty()) {
            throw new ProductNotFoundExcption("Product with id " + id + " not found");
        }
        productRepo.deleteById(id);

    }
}
