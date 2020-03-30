package com.soft1851.spring.ioc.app;
import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName StudentTest
 * @Description TODO
 * @Author zhent
 * @Date 2020/3/17
 **/
public class AppXMLTest {
//    xml文件
    private static Logger logger = LoggerFactory.getLogger(AppXMLTest.class);
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //Student
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
        //Phone
        Phone phone = (Phone) ac.getBean("phone");
        System.out.println(phone);
    }
}