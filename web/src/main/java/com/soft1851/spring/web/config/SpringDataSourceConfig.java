package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author wanghuanle
 * @date 2020/3/19
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
public class SpringDataSourceConfig {
   /**
    * 数据连接池地址配置
    *
    * @return druidDataSource
    */
   @Bean
   public DruidDataSource druidDataSource() {
      DruidDataSource druidDataSource = new DruidDataSource();
      druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
      druidDataSource.setUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
      druidDataSource.setUsername("root");
      druidDataSource.setPassword("root");
      return druidDataSource;
   }

   @Bean
   public JdbcTemplate jdbcTemplate() {
      return new JdbcTemplate(druidDataSource());
   }
}
