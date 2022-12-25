package laba9;

import annotaition.Column;
import annotaition.Table;
@Table(name = "Human")
public class Human {
    @Column(name = "name", isNullable = false)
    private String name;

    @Column(name = "age", isNullable = false)
    private int age;

    @Column(name = "height", isNullable = false)
    private int height;

    @Column(name = "weight", isNullable = false)
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Human(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
