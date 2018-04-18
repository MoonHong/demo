package com.example.demo.person.controller;

import com.example.demo.person.result.PageResult;
import com.example.demo.person.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangmy on 2018/4/17
 */

@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    /**
     *
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @GetMapping("/list")
    public PageResult getList(@RequestParam("pageNo") Integer pageNo,
                              @RequestParam("pageSize") Integer pageSize,
                              @RequestParam(value = "searchKey",required = false) String searchKey){
        return courseService.getList(pageNo,pageSize,searchKey);
    }
}
