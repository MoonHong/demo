package com.example.demo.person.mapper;

import com.example.demo.person.domain.Person;
import org.apache.ibatis.annotations.Mapper;

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
}
