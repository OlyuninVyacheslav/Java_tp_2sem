package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Product{
    @Getter
    private int id;
    @Getter
    private String Title;
    @Getter
    private int Cost;
    @Override
    public String toString() {
        return this.getId() + " " + this.getTitle() + " " + this.getCost();
    }
    public Product Clone(){
        return new Product(this.id, this.Title, this.Cost);
    }
}
