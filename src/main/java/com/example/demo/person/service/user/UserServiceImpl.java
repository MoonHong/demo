package com.example.demo.person.service.user;

import com.example.demo.person.domain.User;
import com.example.demo.person.mapper.UserMapper;
import com.example.demo.person.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by huangmy on 2018/8/2
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable
    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<User> page = userMapper.list();
        return new PageResult(page);
    }

    @Cacheable(key = "#p0")
    @Override
    public User getById(Long id) {
        if (id == null) {
            return null;
        }
        User user = userMapper.getById(id);
        if (user == null) {
            return null;
        }
        return user;
    }

    @CachePut(key = "#p0.id")
    @Override
//    @Cacheable(value = "user",key = "#p0.id")
    public void saveAndUpdate(User user) {
        if (user.getId() == null) {
            userMapper.add(user);

        } else {
            userMapper.update(user);

        }
    }
}
