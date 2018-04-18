package com.example.demo.person.service.course;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.person.domain.Course;
import com.example.demo.person.mapper.CourseMapper;
import com.example.demo.person.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangmy on 2018/4/17
 */
@Service
public class CourseServiceImpl implements CourseService{


    @Autowired
    private CourseMapper courseMapper;

    /**
     * 获取列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @Override
    public PageResult getList(Integer pageNo, Integer pageSize,String searchKey) {
        PageHelper.startPage(pageNo,pageSize);
        if (StringUtils.isEmpty(searchKey)) {
            searchKey = null;
        }
        if (!StringUtils.isEmpty(searchKey)) {
            searchKey = "%" + searchKey + "%";
        }
        Page<Course> page=courseMapper.getList(searchKey);
        return new PageResult(page);
    }
}
