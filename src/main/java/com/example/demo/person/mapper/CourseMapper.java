package com.example.demo.person.mapper;

import com.example.demo.person.domain.Course;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huangmy on 2018/4/17
 */
@Mapper
public interface CourseMapper {


    /**
     * 获取列表
     *
     * @return
     */
    Page<Course> getList(@Param("searchKey") String searchKey);
}
