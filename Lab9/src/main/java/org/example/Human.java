package org.example;

import annotaition.Column;
import annotaition.Table;
@Table(name = "Human")

public class Human {

        @Column(name = "name", isNullable = false)
        private String name;

        @Column(name = "age", isNullable = false)
        private Integer age;

        @Column(name = "growth", isNullable = false)
        private Integer growth;

        @Column(name = "weight", isNullable = false)
        private Integer weight;

        public Human (String name, Integer age, Integer growth, Integer weight) {
            this.name = name;
            this.age = age;
            this.growth = growth;
            this.weight = weight;
        }

        public String  getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getGrowth() {
            return growth;
        }

        public void setGrowth(Integer growth) {
            this.growth = growth;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

