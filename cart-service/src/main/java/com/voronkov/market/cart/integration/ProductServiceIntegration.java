package com.voronkov.market.cart.integration;

import com.voronkov.market.api.ProductDto;
import com.voronkov.market.api.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {

        private final WebClient productServiceWebClient;

        public ProductDto findById(Long id) {
                return productServiceWebClient.get()
                        .uri("/api/v1/products/" + id)
                        .retrieve()
                        .onStatus(
                                httpStatus -> httpStatus.value() == HttpStatus.NOT_FOUND.value(),
                                clientResponse -> Mono.error(new ResourceNotFoundException("Товар не найден в продуктовом МС"))
                        )
                        // .onStatus(HttpStatus::is4xxClientError)
                        .bodyToMono(ProductDto.class)
                        .block();
        }
}
