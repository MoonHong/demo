package com.example.demo.person;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.person.config.MD5Util;
import com.example.demo.person.domain.Person;
import com.example.demo.person.domain.PersonTest;
import org.springframework.beans.BeanUtils;

/**
 * Created by huangmy on 2018/4/27
 */
public class test {


    public static void main(String[] args) throws Exception{

//        String str="hcn.chaoyang.fsdf.fdsfsd.fdsfsd.sdfsdf.fsfsd.admin";
//       String[]a=str.split("\\.");
//
//        System.out.println(a[a.length -1]);

//        System.out.println((int)((Math.random()*9+1)*100000));
//
//        Integer passWord=(int)((Math.random()*9+1)*100000);
//        String password=passWord.toString();
//        MD5Util.encryptMD5(password);
//        System.out.println(MD5Util.encryptMD5(password));
//        System.out.println(MD5Util.encryptMD5(password).length());

//        Person person=new Person();
//        int a=10;
//        long b=a;
//        person.setId(b);
//        person.setName("ni");
//        PersonTest personTest=new PersonTest();
//        personTest.setWeight("6786");
//        BeanUtils.copyProperties(person,personTest);
//        System.out.println(person);
//        System.out.println(personTest);
//        System.out.println(JSONObject.toJSONString(person));
//        System.out.println(JSONObject.toJSONString(personTest));

        String str=new String("hell[oy]");
        String string=new String("hoyhjh");
        System.out.println(str.replaceAll("oy","ti"));
    }
}
