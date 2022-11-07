package com.voronkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    @Autowired
    private ProductRepository repository;
    List<Product> cartProducts = new ArrayList<>();

    public void edit(int id){
        if (id<repository.getProductList().size()){
            cartProducts.add(repository.getProductList().get(id));
        }else System.out.println("No such product");
    }

    public void delete(int id){
        if (id<repository.getProductList().size()){
            cartProducts.remove(repository.getProductList().get(id));
        }else System.out.println("No such product");
    }

    public void showCart(){
        for (Product prd :
                cartProducts) {
            System.out.println(prd);
        }
        System.out.println("Size:" + cartProducts.size());
    }


}
