package com.voronkov.market.core.converter;

import com.voronkov.market.api.ProductDto;

import com.voronkov.market.api.ResourceNotFoundException;
import com.voronkov.market.core.entity.Category;
import com.voronkov.market.core.entity.Product;
import com.voronkov.market.core.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryService categoryService;

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(),product.getCategory().getTitle());
    }

    public Product dtoToEntity(ProductDto productDto){
        Product p = new Product();
        p.setId(productDto.getId());
        p.setTitle(productDto.getTitle());
        p.setPrice(productDto.getPrice());
        Category c = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Категория не найдена"));
        p.setCategory(c);
        return p;
    }
}
