package com.voronkov.market.core.repo;


import com.voronkov.market.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRep extends JpaRepository<Order,Long> {

}

