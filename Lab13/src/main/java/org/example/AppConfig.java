package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "productService")
    public ProductService ProductService(){
        return new ProductService();
    }
    @Bean(name = "cart")
    public Cart Cart(){
        return new Cart();
    }
}
