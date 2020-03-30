package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wanghuanle
 * @date 2020/3/19
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {
   @Value("com.mysql.jdbc.Driver")
   private String driverClassName;
   @Value("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true")
   private String jdbcUrl;
   @Value("root")
   private String userName;
   @Value("root")
   private String password;

   /**
    * 数据连接池地址配置
    *
    * @return druidDataSource
    */
   @Bean
   public DruidDataSource druidDataSource() {
      DruidDataSource druidDataSource = new DruidDataSource();
      druidDataSource.setDriverClassName(driverClassName);
      druidDataSource.setUrl(jdbcUrl);
      druidDataSource.setUsername(userName);
      druidDataSource.setPassword(password);
      return druidDataSource;
   }

   /**
    * jdbcTemplate模板配置
    * @return
    */
   @Bean
   public JdbcTemplate jdbcTemplate() {
      return new JdbcTemplate(druidDataSource());
   }

   /**
    * 装配事务管理器
    * @param druidDataSource
    * @return
    */
   @Bean
   public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
      return new DataSourceTransactionManager(druidDataSource);
   }
}
