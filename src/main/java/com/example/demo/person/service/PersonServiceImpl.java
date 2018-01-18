package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.mapper.PersonMapper;
import com.example.demo.person.result.BaseResult;
import com.example.demo.person.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonMapper personMapper;

    /**
     * @param person
     * @return
     */
    @Override
    public BaseResult add(Person person) {
        Integer result = personMapper.add(person);
        if (result < 0) {
            return BaseResult.error("ERROR", "添加失败");
        }
        return BaseResult.success("添加成功");
    }


    /**
     * @param person
     * @return
     */
    @Override
    public BaseResult update(Person person) {
        if (person.getId() == null) {
            return BaseResult.parameterError();
        }
        Integer valid=personMapper.validName(person.getId(),person.getName());
        if (valid>0){
            return BaseResult.error("ERROR","名称重复");
        }
        Integer result = personMapper.update(person);
        if (result < 0) {
            return BaseResult.error("ERROR", "修改失败");
        }
        return BaseResult.success("修改成功");
    }


    /**
     * @param id
     * @return
     */
    @Override
    public BaseResult findById(Long id) {
        if (id == null) {
            return BaseResult.parameterError();
        }
        Person person = personMapper.findById(id);
        if (person == null) {
            return BaseResult.notFound();
        }
        return BaseResult.success(person);
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
        if (result==idList.size()){
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("ERROR","删除失败");
    }

    /**
     *
     *
     * @param idList
     * @return
     */
    @Override
    public BaseResult deleteById(List<Long> idList) {
        Integer result=personMapper.cute(idList);
        if (result<idList.size()){
            return BaseResult.error("ERROR","未删除完全");
        }
        if (result==idList.size()){
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("ERROR","删除失败");
    }
}
