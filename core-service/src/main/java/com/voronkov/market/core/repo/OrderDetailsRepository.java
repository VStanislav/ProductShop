package com.voronkov.market.core.repo;

import com.voronkov.market.core.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderItem, Long> {

    public List<OrderItem> findOrderDetailsByOrder_Id(Long orderId);
}
