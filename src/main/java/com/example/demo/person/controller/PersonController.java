package com.example.demo.person.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.person.domain.Person;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;
import com.example.demo.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param person
     * @return
     */
    @PostMapping("/add")
    public void add(@RequestBody Person person) {
        personService.add(person);
    }


    /**
     * @param person
     * @return
     */
    @PostMapping("/update")
    public void update(@RequestBody Person person) {
        personService.update(person);
    }


    /**
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public Person findById(@RequestParam(value = "id") Long id) {
        return personService.findById(id);
    }

    /**
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    //@GetMapping("/list")
    public PageResult list(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return personService.list(pageNo, pageSize);
    }


    /**
     * @return
     */
    @GetMapping("/stadiumList")
    public PageResult getList() {
        return personService.getList();
    }

    /**
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public BaseResult delete(@RequestParam("id") Long id) {
        return personService.delete(id);
    }


    /**
     * @param jsonObject
     * @return
     */
    @PostMapping("/deleteByIdList")
    public BaseResult deleteByIdList(@RequestBody JSONObject jsonObject) {
        String status = jsonObject.getString("status");
        List<Long> idList = jsonObject.getJSONArray("idList").toJavaList(Long.class);
        return personService.deleteIdList(status, idList);
    }


    /**
     * @param jsonArray
     * @return
     */
    @PostMapping("/deleteById")
    public BaseResult deleteId(@RequestBody JSONArray jsonArray) {
        List<Long> idList = jsonArray.toJavaList(Long.class);
        return personService.deleteById(idList);
    }

}
