package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Hello;
import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import com.soft1851.spring.ioc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author zhent
 * @Date 2020/3/17
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class AppConfig {
    @Bean
    public Phone phone(){
        return new Phone();
    }
    @Bean
    public Student student(){
        return new Student();
    }
    @Bean
    public  Hello hello(){
        return  new Hello();
    }
    @Bean
    public User user(){
        return new User();
    }
}