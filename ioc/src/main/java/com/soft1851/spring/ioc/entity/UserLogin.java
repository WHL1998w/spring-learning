package com.soft1851.spring.ioc.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UserLogin
 * @Description TODO
 * @Author zhent
 * @Date 2020/3/12
 **/
public class UserLogin {
    private  User admin;

     public  boolean userLogin(User user){
         ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
         admin=(User)ac.getBean("user");
         if (admin.getAccount().equals(user.getAccount())){
             if (admin.getPassword().equals(user.getPassword())){
                 System.out.println("登录成功");
                 return true;
             }
         }
    return false;
     }
     public  User getAdmin(){
         return admin;
     }
     public  void  setAdmin(User admin){
         this.admin=admin;
     }
}