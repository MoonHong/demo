package com.example.demo.person;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.person.domain.Link;
import com.example.demo.person.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * @author by hmy
 * @version <0.1>
 * @created on 2018-01-15.
 */
public class index {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setId("01");
        user.setName("张三");
        user.setAge(33);


        Link link = new Link();
        link.setAddress("浙江省衢州市");
        link.setPhone("13326105007");
        link.setQQ("1049313183");
        user.setLink(link);

        Map map = new HashMap();
        map.put("aa", "this is aa");
        map.put("bb", "this is bb");
        map.put("cc", "this is cc");
        user.setMap(map);

        List list = new ArrayList();
        list.add("杭州");
        list.add("衢州");
        user.setList(list);

        Set set = new HashSet();
        set.add("篮球");
        set.add("足球");
        set.add("兵乒球");
        user.setSet(set);

        ObjectMapper mapper = new ObjectMapper();
        String json=mapper.writeValueAsString(user);
        System.out.println(json);

       Map m=mapper.readValue(json,Map.class);
      json=mapper.writeValueAsString(m);
        System.out.println(json);
    }
}
