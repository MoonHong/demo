package com.example.demo.person;

import com.example.demo.person.domain.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huangmy on 2018/7/30
 */
public class practice {


    public static void main(String[] args) {

        int[] integers = {1, 2, 3, 4};
//        for (int j = 0; j < integers.length; j++) {
//            int i=integers[j];
//            System.out.println(i);
//        }

//        for (Integer j:integers){
//            System.out.println(j);
//        }

        List<Person> list=new ArrayList<>();
        Person person=new Person();
        person.setName("a");
        person.setCreateDate(new Date());
        list.add(person);
        list.forEach(t->{

        });
    }
}
