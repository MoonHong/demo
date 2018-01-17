package com.example.demo.person.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-17.
 */
public class User {


    private String id;

    private String name;

    private int age;

    private Link link;

    private Map map;

    private Set set;

    private List list;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", link=" + link +
                ", map=" + map +
                ", set=" + set +
                ", list=" + list +
                '}';
    }
}
