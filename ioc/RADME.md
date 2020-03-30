# 关于Spring的配置和注解的说明

## 1.基于xml方式来做bean的配置
- <bean>标签的使用:id class
- 构造器注入:ref引用其他对象
- setter注入：p:简写形式

## 2.两种方式可以获得xml中的bean
- ApplicationContext得到上下文、 ac.getBean('')，main方法使用
- @Autowired注解，单元测试中使用,注意命名规范

## 3.基于Java类来做bean的配置（主流）
- 配置类一定要加上@Configuration
- 配置中配置bean的方法，要加上@Bean注解
```
@Configuration
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
```

## 4.如何在SpringFramework中获得Java类配置的bean？
- main方法
```
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //手动开启扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        ctx.refresh();
        Book book = (Book) ctx.getBean("book");
        book.setName("java");
        book.setPrice(88.8);
        System.out.println(book);
```
- 单元测试
> 注意在xml配置文件中手动开启扫包操作
```
 <context:component-scan base-package="com.soft1851.spring.ioc.config"/>
```

运行结果
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317110411.png)

####xml配置到Java配置的改造
#####1.
```
<bean id="" class ="">
<property name="" value=""> 
<property name="" value=""> 
</bean>
```
👇
```
@Bean 
...  ...=new ...()；
... .set..();
return ...;
```
#####2. 
```
<context:annotation-config/>
 <context:component-scan base-package=""/>
```
👇
```
@ComponentScan("")
```
#####3.测试
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
```
👇
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringDataSourceConfig.class}）
```
#####4.dao层、service层、controller层
可以用不同的注解
@Repository
@Service
@Controller
@Component可以统一代替
#####5.本次过程
######config部分
> 1.利用@ComponentScan(包名)注解来扫包
> 2.配置DruidDataSource
> 3.JdbcTemplete设置druidDataSource
> 4.新增各接口的bean
 接口实现类部分
> 1.使用@Component注解
> 2.创建一个JdbcTemplate对象
> 3.构造对象的全参方法和set方法
测试部分
> 1.AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataSourceConfig.class);
> 2.手动开启扫描
> 3.调用实现类方法





