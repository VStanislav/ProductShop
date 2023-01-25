package com.voronkov.market.cart.model;

import com.voronkov.market.api.ProductDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart(){this.items = new ArrayList<>();}

    public void add(ProductDto product){
        for (CartItem item : items){
            if (product.getId().equals(item.getProductId())){
                item.changeQuantity(1);
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product.getId(),product.getTitle(),1,product.getPrice(),product.getPrice()));
        recalculate();
    }

    public void remove(Long productId){
        if (items.removeIf(item -> item.getProductId().equals(productId))){
            recalculate();
        }
    }

    public void clear(){
        items.clear();
        totalPrice=0;
    }

    private void recalculate() {
        totalPrice=0;
        for (CartItem item:items){
            totalPrice += item.getPrice();
        }
    }
}
