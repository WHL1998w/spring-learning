# Spring JDBC集成操作（Forum Post）
### 一.Spring JDBC的xml配置版
#### 1.数据库属性文件配置（db.properties）
- 注意几个属性的作用,数据库的名称，用户名，密码一定要正确
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120719.png)
#### 2.Spring主配置文件(applicationContext.xml)
- 开启注解扫描
- 读入外部数据库属性文件
- 配置数据源
- 配置JdbcTemplate
  ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120732.png)
#### 3.实体类(@Data @AllArgsConstructor @NoArgsConstructor @Builder)
> 尤其要注意，加了@Builder注解后，默认的无参构造器会失效，务必加上全参和无参构造器注解
> **@AllArgsConstructor和@NoArgsContrutor**
> ![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120858.png)
#### 4.接口
> 声明基本的增删改查方法
#### 5.接口实现类
- 添加注解：@Repository
- 使用@Autowired，引入JdbcTemplate
#### 6.单元测试
- 两个注解
```
    - @RunWith(SpringJUnit4ClassRunner.class)
    - @ContextConfiguration(locations = {"/xml文件名.xml"})
    - @Autowired引入dao接口
```
### 二.Spring JDBC的注解配置版
#### 1.config部分

- 利用@ComponentScan(包名)注解来扫包
- 加@Beac注解配置DruidDataSource和JdbcTemplete
- JdbcTemplate设置druidDataSource为参数，两者是依赖关系

#### 2.impl接口实现类部分

- 使用@Component注解

- 创建一个JdbcTemplate对象

- 构造对象的全参方法和set方法

#### 3.测试部分
- AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);

- 手动开启扫描(scan)

- 调用接口中的进行测试方法
#### 4.单元测试
- 与xml配置不用的是将locations改成了classes
> @ContextConfiguration(classes = {JdbcConfig.class})

#### 5.注意点

- 每一部分的注解一定要加

- bean中的id等于对象名字，如book,phone
