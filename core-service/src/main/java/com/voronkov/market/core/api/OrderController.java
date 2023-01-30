package com.voronkov.market.core.api;

import com.voronkov.market.core.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestHeader String username) {
        log.info("Created");
        orderService.createOrder(username);
    }
}
