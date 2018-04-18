package com.example.demo.person.service.course;

import com.example.demo.person.result.PageResult;

/**
 * Created by huangmy on 2018/4/17
 */
public interface CourseService {


    /**
     * 获取列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    PageResult getList(Integer pageNo, Integer pageSize,String searchKey);
}
