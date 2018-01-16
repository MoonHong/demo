package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;

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


    /**
     *
     *
     * @param id
     * @return
     */
    BaseResult findById(Long id);


    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize);


    /**
     *
     *
     * @param id
     * @return
     */
    BaseResult delete(Long id);
}
