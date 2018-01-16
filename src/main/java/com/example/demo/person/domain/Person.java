package com.example.demo.person.domain;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
public class Person {

    private Long id;

    private String eyes;

    private String name;

    private int height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", eyes='" + eyes + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
