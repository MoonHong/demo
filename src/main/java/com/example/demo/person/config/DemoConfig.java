package com.example.demo.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.xml.ws.spi.http.HttpContext;
import java.util.List;


/**
 * Created by huangmy on 2018/4/10
 */
@Configuration
public class DemoConfig extends WebMvcConfigurerAdapter {



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 消息转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        converters.add(mappingJackson2HttpMessageConverter);
    }

    /**
     * 解决跨域问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }
}
