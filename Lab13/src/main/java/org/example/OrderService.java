package org.example;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderService {
    static public void MakeOrder(Cart cart){
        for (int i = 0; i < cart.getProductList().size(); i++) {
            System.out.printf("%d) #%s р\n",i + 1, cart.getProductList().get(i).toString());
        }
        System.out.printf("Всего: %d р",cart.getProductList().stream().mapToInt(Product::getCost).sum());
    }
}
