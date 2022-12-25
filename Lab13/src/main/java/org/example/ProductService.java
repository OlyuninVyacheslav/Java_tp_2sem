package org.example;
import lombok.Getter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductService {
    @Getter
    private final List<Product> productList;

    public ProductService(){
        productList = new ArrayList<>();
    }
    public void PrintAll(){
        for (Product p: productList) {
            System.out.println(p.toString());
        }
    }
    public Product FindByTitle(String title){
        return productList.stream().filter(p -> Objects.equals(p.getTitle(), title)).toList().get(0).Clone();
    }
    @PostConstruct
    private void Fill(){
        productList.add(new Product(0, "Набор_вилок_4_шт", 50));
        productList.add(new Product(1, "Чайник_не_электрический", 520));
        productList.add(new Product(2, "Утюг_на_углях", 900));
        productList.add(new Product(3, "Платок_носовой", 100));
        productList.add(new Product(4, "Фонарик_походный", 359));
        productList.add(new Product(5, "Смысл_жизни", 9000999));
        productList.add(new Product(6, "Алмаз_стеклянный", 799));
        productList.add(new Product(7, "Чехол_для_зубочисток", 120));
        productList.add(new Product(8, "Филе_курицы_состаренное", 359));
        productList.add(new Product(9, "Скобы_для_степлера", 670));
    }
}
