package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.result.BaseResult;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
public interface PersonService {

    /**
     *
     *
     * @param person
     * @return
     */
    BaseResult add(Person person);


    /**
     *
     *
     * @param person
     * @return
     */
    BaseResult update(Person person);
}
