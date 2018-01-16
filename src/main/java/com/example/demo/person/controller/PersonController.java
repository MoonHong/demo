package com.example.demo.person.controller;

import com.example.demo.person.domain.Person;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;
import com.example.demo.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
@RestController
@RequestMapping("/index")
public class PersonController {

    @Autowired
    private PersonService personService;


    /**
     *
     *
     * @param person
     * @return
     */
    @PostMapping("/test")
    public BaseResult add(@RequestBody Person person){
        return personService.add(person);
    }


    /**
     *
     *
     * @param person
     * @return
     */
    @PostMapping("/update")
    public BaseResult update(@RequestBody Person person){
        return personService.update(person);
    }


    /**
     *
     *
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public BaseResult findById(@RequestParam(value = "id") Long id){
        return personService.findById(id);
    }

    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public PageResult list(Integer pageNo,Integer pageSize){
        return personService.list(pageNo,pageSize);
    }
}
