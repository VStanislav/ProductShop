package com.voronkov.market.core.api;

import com.voronkov.market.api.ProductDto;
import com.voronkov.market.api.ResourceNotFoundException;
import com.voronkov.market.core.entity.Product;
import com.voronkov.market.core.converter.ProductConverter;
import com.voronkov.market.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

   @GetMapping
    public List<ProductDto> findAllProducts(){
       return productService.findAll().stream().map(productConverter::entityToDto).collect(Collectors.toList());
   }

   @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product productDao = productService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Продукт не найден с таким ID " + id));
        return productConverter.entityToDto(productDao);
    }

    @PostMapping("/{id}")
    public ProductDto createNewProduct(@RequestBody ProductDto productDto) {
        Product p = productService.createNewProduct(productDto);
        return productConverter.entityToDto(p);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
       productService.deleteById(id);
    }




//
//    @GetMapping("/order/add/{id}")
//    public void addProductIntoOrder(@PathVariable(name = "id") Long id) {
//        order.addIntoOrder(id);
//    }
//
//    @GetMapping("/order/show")
//    public List<ProductDto> showProductIntoOrder() {
//        return order.getOrderList();
//    }
//
//
//
//    @DeleteMapping("/base/{id}")
//    public void findBaseById(@PathVariable Long id) {
//        Product productDao = productService.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Продукт не найден с таким ID " + id));
//        productService.deleteById(productDao.getId());
//    }
//
//    @PutMapping("/base")
//    public ProductDto updateProduct(@RequestBody ProductDto productDtoCl) {
//       validator.validate(productDtoCl);
//        Product p = productService.update(productDtoCl);
//        return productConverter.daoToDto(p);
//    }
//
//    @PostMapping("/base")
//    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
//        validator.validate(productDto);
//        Product p = productConverter.dtoToDao(productDto);
//        p = productService.save(p);
//         return productConverter.daoToDto(p);
//    }
//
//    @GetMapping
//    public Page<ProductDto> findBetweenMinMax(
//            @RequestParam(name = "min_price", defaultValue = "0") Integer minPrice,
//            @RequestParam(name = "max_price", required = false) Integer maxPrice,
//            @RequestParam(name = "p", defaultValue = "1") Integer page,
//            @RequestParam(name = "name", required = false) String name
//    ) {
//        if (page < 1) {
//            page = 1;
//        }
//        return productService.findAll(minPrice, maxPrice, name, page).map(
//
//                p -> productConverter.daoToDto(p)
//        );
//    }
}




