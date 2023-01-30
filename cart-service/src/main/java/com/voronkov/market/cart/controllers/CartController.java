package com.voronkov.market.cart.controllers;

import com.voronkov.market.api.CartDto;
import com.voronkov.market.cart.converter.CartConverter;
import com.voronkov.market.cart.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){cartService.add(id);}

    @GetMapping("/clear")
    public void clearCart(){cartService.clear();}

    @GetMapping("/remove/{id}")
    public void clearFromCart(@PathVariable Long id){cartService.remove(id);}

    @GetMapping
    private CartDto getCurrentCart(){return cartConverter.entityToDto(cartService.getCurrentCard());}
}
