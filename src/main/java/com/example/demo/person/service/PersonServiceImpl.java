package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.domain.Stadium;
import com.example.demo.person.mapper.PersonMapper;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
@Service
@CacheConfig(cacheNames = "person")
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonMapper personMapper;

    /**
     * @param person
     * @return
     */
    @Override
//    @CachePut(key = "#p0.id")
    @Cacheable(value = "person", keyGenerator = "firstParamKeyGenerator")
    public void add(Person person) {
        personMapper.add(person);

    }


    /**
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "person", key = "#p0")
    public void update(Person person) {
        personMapper.update(person);
    }


    /**
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "person", keyGenerator = "firstParamKeyGenerator")
    public Person findById(Long id) {
        Person person = personMapper.findById(id);
        return person;
    }


    /**
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Person> page = personMapper.list();
        return new PageResult(page);
    }


    /**
     * @param id
     * @return
     */
    @Override
    public BaseResult delete(Long id) {
        if (id == null) {
            return BaseResult.parameterError();
        }
        Integer result = personMapper.delete(id);
        if (result < 0) {
            return BaseResult.error("ERROR", "删除失败");
        }
        return BaseResult.success("删除成功");
    }


    /**
     * @param status
     * @param idList
     * @return
     */
    @Override
    public BaseResult deleteIdList(String status, List<Long> idList) {

        if (StringUtil.isEmpty(status) || idList.size() < 0 || idList == null) {
            return BaseResult.parameterError();
        }
        Integer result = personMapper.deleteIdList(status, idList);
        if (result < idList.size()) {
            return BaseResult.error("ERROR", "未完全删除");
        }
        if (result == idList.size()) {
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("ERROR", "删除失败");
    }

    /**
     * @param idList
     * @return
     */
    @Override
    public BaseResult deleteById(List<Long> idList) {
        Integer result = personMapper.cute(idList);
        if (result < idList.size()) {
            return BaseResult.error("ERROR", "未删除完全");
        }
        if (result == idList.size()) {
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("ERROR", "删除失败");
    }


    /**
     * @return
     */
    @Override
    public PageResult getList() {
        Page<Stadium> page = personMapper.getList();
        return new PageResult(page);
    }
}
