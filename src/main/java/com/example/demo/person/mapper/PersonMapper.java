package com.example.demo.person.mapper;

import com.example.demo.person.domain.Person;
import com.example.demo.person.domain.Stadium;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    /**
     *
     *
     * @param id
     * @return
     */
    Integer delete(@Param("id") Long id);


    /**
     *
     *
     * @param status
     * @param idList
     * @return
     */
    Integer deleteIdList(@Param("status") String status,
                         @Param("idList") List<Long> idList);


    /**
     *
     *
     * @param idList
     * @return
     */
    Integer cute(@Param("idList") List<Long> idList);


    /**
     *
     *
     * @param id
     * @param name
     * @return
     */
    Integer validName(@Param("id") Long id,@Param("name") String name);




    /**
     *
     *
     * @return
     */
    Page<Stadium> getList();

}

