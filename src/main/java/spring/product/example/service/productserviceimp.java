package spring.product.example.service;

import spring.product.example.model.Product;
import spring.product.example.repository.Productrepos;

import java.util.List;
@Service
public class productserviceimp implements com.example.demo.service.ProductService {
    private final Productrepos productrepos;
    public productserviceimp(Productrepos productrepos) {
        this.productrepos = productrepos;
    }
    @Override
    public void addProduct(String name, int id, String description, double price, String category, String manufacturer, String dateOfManufacture) {
        productrepos.saveProduct(Product.builder().name(name).id(id).description(description).price(price).category(category).manufacturer(manufacturer).dateOfManufacture(dateOfManufacture).build());
    }

    @Override
    public Product saveProduct(Product product) {
        return productrepos.saveProduct(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productrepos.getProductById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productrepos.getProductByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productrepos.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productrepos.deleteProduct(id);
    }

    @Override
    public void deleteProductByName(String name) {
        productrepos.deleteProductByName(name);
    }
}
