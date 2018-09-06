package com.example.demo.person.domain;

/**
 * Created by huangmy on 2018/8/7
 */
public class PersonTest extends Person{

    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "weight='" + weight + '\'' +
                '}';
    }
}
