package spring.product.example.service;

import java.util.List;

public interface Productserv {
    public void addProduct(product product);
    public void updateProduct(int id, product product);
    public void deleteProduct(int id);
    public product getProductById(int id);
    public product getProductByName(String name);
    public List<product> findAll();
}
