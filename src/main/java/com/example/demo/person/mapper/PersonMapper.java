package com.example.demo.person.mapper;

import com.example.demo.person.domain.Person;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
@Mapper
public interface PersonMapper {


    /**
     *
     *
     * @param person
     * @return
     */
    Integer add(Person person);


    /**
     *
     *
     * @param person
     * @return
     */
    Integer update(Person person);


    /**
     *
     *
     * @param id
     * @return
     */
    Person findById(@Param("id") Long id);


    /**
     *
     *
     * @return
     */
    Page<Person> list();
}

