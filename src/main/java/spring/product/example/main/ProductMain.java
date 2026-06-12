package com.example.demo.main;

public class ProductMain {
    ProductControler productControler;
    public ProductMain(ProductControler productControler) {
        this.productControler = productControler;
    }
    public void run() {
        productControler.addProduct("Product1", 1, "Description1", 1.0, "Category1", "Manufacturer1", "DateOfManufacture1");
    }
    public static void main(String[] args) {
        ProductMain productMain = new ProductMain(new ProductControler(new ProductSevImplementation(new productrepo())));
        productMain.run();
    }
}
