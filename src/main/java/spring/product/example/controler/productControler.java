package spring.product.example.controler;

import spring.product.example.model.Product;
@Controller
public class productControler {
    private final com.example.demo.service.ProductService productService;
    public ProductControler(com.example.demo.service.ProductService productService) {
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
