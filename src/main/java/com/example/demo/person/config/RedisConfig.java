package com.example.demo.person.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

/**
 * Created by huangmy on 2018/8/3
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig extends CachingConfigurerSupport{

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        return factory;
    }


    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        RedisTemplate<?, ?> template = new StringRedisTemplate(factory);
        return template;
    }


    /**
     * 生成key的策略【自定义第三种】
     * 使用范围：仅适用于选取第一个参数做键的情况
     * 由于reposotory上不能直接使用spel表达式作key，故而采用key的生成策略的方式来替换
     *
     * 使用时在注解@Cacheable(value = "admins",keyGenerator = "firstParamKeyGenerator")中指定
     * @return
     */
    @Bean(name = "firstParamKeyGenerator")
    public KeyGenerator firstParamKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(params[0].toString());
                return sb.toString();
            }
        };
    }


}
