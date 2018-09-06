package com.example.demo.person.mapper;

import com.example.demo.person.domain.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huangmy on 2018/8/2
 */

@Mapper
public interface UserMapper {


    /**
     *
     *
     * @return
     */
    Page<User> list();

    /**
     *
     *
     * @param id
     * @return
     */
    User getById(@Param("id") Long id);


    /**
     *
     *
     * @param user
     * @return
     */
    Integer add(User user);


    /**
     *
     *
     * @param user
     * @return
     */
    Integer update(User user);
}
