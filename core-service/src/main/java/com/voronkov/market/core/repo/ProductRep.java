package com.voronkov.market.core.repo;


import com.voronkov.market.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}

