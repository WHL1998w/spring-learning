package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.PhoneConfig;
import com.soft1851.spring.ioc.config.StudentConfig;
import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentConfigTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/19
 **/

public class StudentConfigTest {
    //改造
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
        //手动开启扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        Student student = (Student) ctx.getBean("student");
        //list
        List<Phone> phonesList = new ArrayList<>();
        Phone  phone1 = (Phone) ctx.getBean("phone");
        phone1.setBrand("IphoneXS");
        phone1.setPrice(9999.9);
        Phone  phone2 = (Phone) ctx.getBean("phone");
        phone2.setBrand("小米9");
        phone2.setPrice(3299.9);
        phonesList.add(phone1);
        phonesList.add(phone2);
        Student student2 = (Student) ctx.getBean("student");
        student.setName("Crihero");
        student.setAge(22);
        student2.setName("zhent");
        student2.setAge(22);
        //Map
        Map<String,Student> studentMap=new HashMap<>();
        studentMap.put("1",student);
        studentMap.put("2",student2);
        System.out.println(studentMap);
        student.setPhones(phonesList);
        System.out.println(student);
    }

}