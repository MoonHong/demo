package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.mapper.PersonMapper;
import com.example.demo.person.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
@Service
public class PersonServiceImpl implements PersonService{


    @Autowired
    private PersonMapper personMapper;

    /**
     *
     *
     * @param person
     * @return
     */
    @Override
    public BaseResult add(Person person) {
        Integer result=personMapper.add(person);
        if (result<0){
            return BaseResult.error("ERROR","添加失败");
        }
        return BaseResult.success("添加成功");
    }
}
