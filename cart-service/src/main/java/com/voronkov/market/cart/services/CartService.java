package com.voronkov.market.cart.services;

import com.voronkov.market.api.ProductDto;
import com.voronkov.market.cart.integration.ProductServiceIntegration;
import com.voronkov.market.cart.model.Cart;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart cart;

    @PostConstruct
    public  void init(){cart=new Cart();}

    public Cart getCurrentCard(){return cart;}

    public void add(Long productId){
        ProductDto product = productServiceIntegration.findById(productId);
        cart.add(product);
    }

    public void remove(Long productId){cart.remove(productId);}

    public void clear(){cart.clear();}
}
