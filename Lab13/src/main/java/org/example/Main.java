package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService",ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        cart.Add(productService.FindByTitle("Чайник_не_электрический"));
        cart.Add(productService.FindByTitle("Чехол_для_зубочисток"));
        cart.Add(productService.FindByTitle("Смысл_жизни"));
        cart.Add(productService.FindByTitle("Чайник_не_электрический"));
        cart.Add(productService.FindByTitle("Утюг_на_углях"));
        OrderService.MakeOrder(cart);
    }
}