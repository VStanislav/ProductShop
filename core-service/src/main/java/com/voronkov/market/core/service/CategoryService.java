package com.voronkov.market.core.service;

import com.voronkov.market.api.ProductDto;
import com.voronkov.market.core.entity.Category;
import com.voronkov.market.core.repo.CategoryRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRep categoryRep;

    public Optional<Category> findByTitle(String title){
        return categoryRep.findByTitle(title);
    }


}
