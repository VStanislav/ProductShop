package com.voronkov.market.core.repo;


import com.voronkov.market.core.entity.Category;
import com.voronkov.market.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRep extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Product> {
    Optional<Category> findByTitle(String title);
}

