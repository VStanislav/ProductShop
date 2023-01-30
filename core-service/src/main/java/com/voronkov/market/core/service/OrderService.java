package com.voronkov.market.core.service;


import com.voronkov.market.api.CartDto;

import com.voronkov.market.core.entity.Order;
import com.voronkov.market.core.entity.OrderItem;
import com.voronkov.market.core.integrations.CartServiceIntegration;
import com.voronkov.market.core.repo.OrderRep;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRep orderRepository;
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;

    @Transactional
    public void createOrder(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
        Order order = new Order();
        order.setUsername(username);
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItem -> new OrderItem(
                        productService.findById(cartItem.getProductId()).get(),order,
                        cartItem.getQuantity(),
                        cartItem.getPricePerProduct(),
                        cartItem.getPrice()))
                .collect(Collectors.toList()));
        orderRepository.save(order);
        cartServiceIntegration.clear();
    }

}
