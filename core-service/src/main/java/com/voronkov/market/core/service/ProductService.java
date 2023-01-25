package com.voronkov.market.core.service;

import com.voronkov.market.api.ProductDto;
import com.voronkov.market.api.ResourceNotFoundException;
import com.voronkov.market.core.entity.Category;
import com.voronkov.market.core.entity.Product;
import com.voronkov.market.core.repo.ProductRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRep productRepository;
    private final CategoryService categoryServise;

    public List<Product> findAll(){return productRepository.findAll();}
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public Product createNewProduct(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryServise.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Не найден товар по категории"));
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

}
