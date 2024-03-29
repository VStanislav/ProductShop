package com.voronkov.market.core.service;

import com.voronkov.market.core.entity.OrderItem;
import com.voronkov.market.core.repo.OrderItemsRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemsRepository orderDetailsRepository;

    public OrderItem save(OrderItem orderItem) {
        return orderDetailsRepository.save(orderItem);
    }

    public List<OrderItem> findAllByOrderId(Long id){
        return orderDetailsRepository.findOrderItemsByOrderId(id);

    }
}
