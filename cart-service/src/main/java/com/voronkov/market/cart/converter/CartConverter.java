package com.voronkov.market.cart.converter;

import com.voronkov.market.api.CartDto;
import com.voronkov.market.cart.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    public CartDto entityToDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setItems(cart.getItems().stream().map(cartItemConverter::entityToDto).collect(Collectors.toList()));
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;

    }
}
