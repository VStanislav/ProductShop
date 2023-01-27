package com.voronkov.market.core.repo;

import com.voronkov.market.core.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {

    public List<OrderItem> findOrderItemsByOrderId(Long orderId);
}
