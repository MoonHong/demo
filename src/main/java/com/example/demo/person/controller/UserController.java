package com.example.demo.person.controller;

import com.example.demo.person.domain.User;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;
import com.example.demo.person.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangmy on 2018/8/2
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {
        return userService.list(pageNo,pageSize);
    }


    /**
     *
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public User getById(Long id){
        return userService.getById(id);
    }


    @RequestMapping(value = "/saveAndUpdate",method = RequestMethod.POST)
    public void saveAndUpdate(@RequestBody User user){
         userService.saveAndUpdate(user);
    }
}
