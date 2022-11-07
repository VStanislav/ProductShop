package com.voronkov;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        for (int i = 0; i < 5; i++) {
            productList.add(new Product("Product "+i,(int)(Math.random()*100),i));
        }
    }


}
