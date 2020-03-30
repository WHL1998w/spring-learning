package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName PhoneConfig
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/19
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class PhoneConfig {
    @Bean
    public Phone phone(){
       Phone phone=new Phone();
       return  phone;
    }
}