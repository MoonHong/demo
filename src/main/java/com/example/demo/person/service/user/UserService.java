package com.example.demo.person.service.user;

import com.example.demo.person.domain.User;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;

/**
 * Created by huangmy on 2018/8/2
 */
public interface UserService {


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
    User getById(Long id);


    /**
     *
     *
     * @param user
     * @return
     */
    void saveAndUpdate(User user);


}
