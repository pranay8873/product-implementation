package spring.product.example.service;

import spring.product.example.repository.Productrepos;

@Service
public class ProductServImpl implements ProductServ{
    private final Productrepos productrepos;
    public ProductServImpl(Productrepos productrepos) {
        this.productrepos = productrepos;
    }
}
