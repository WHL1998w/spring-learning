package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName HelloTest
 * @Description TODO
 * @Author zhent
 * @Date 2020/3/10
 **/
public class HelloTest {
    public static void main(String[] args) {
        //读取beans的配置文件，得到上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //取出相应的bean
        Hello hello = (Hello) ac.getBean("hello");
        hello.sayHello();
    }
}