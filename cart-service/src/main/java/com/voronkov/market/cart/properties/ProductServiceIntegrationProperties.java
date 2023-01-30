package com.voronkov.market.cart.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "integrations.product-service")
public class ProductServiceIntegrationProperties {
    private String url;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;


}

