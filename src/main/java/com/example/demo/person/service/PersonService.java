package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;

import java.util.List;

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
    void add(Person person);


    /**
     *
     *
     * @param person
     * @return
     */
    void update(Person person);


    /**
     *
     *
     * @param id
     * @return
     */
    Person findById(Long id);


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


    /**
     *
     *
     * @param status
     * @param idList
     * @return
     */
    BaseResult deleteIdList(String status, List<Long> idList);


    /**
     *
     *
     * @param idList
     * @return
     */
    BaseResult deleteById(List<Long> idList);


    /**
     *
     *
     * @return
     */
    PageResult getList();
}
