package org.example;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    @Getter
    private final List<Product> productList;
    public Cart(){
        productList = new ArrayList<>();
    }
    public void Add(Product product){
        productList.add(product);
    }
}
