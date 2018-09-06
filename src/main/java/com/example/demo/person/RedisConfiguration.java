package com.example.demo.person;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by huangmy on 2018/8/2
 */

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {


//    @Bean(name = "firstParamKeyGenerator")
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                StringBuilder sb=new StringBuilder();
//                sb.append(o.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj:objects){
//                    sb.append(obj.toString());
//                }
//                System.out.println("调用redis缓存key:"+sb.toString());
//                return sb.toString();
//            }
//        };
//    }

    /**
     * 采用RedisCacheManager作为缓存管理器
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
}
