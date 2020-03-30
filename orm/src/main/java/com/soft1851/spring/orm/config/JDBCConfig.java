package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JDBCConfig
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/19
 **/
@Configuration
public class JDBCConfig {
    @Bean
    public static DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(8);
        return  druidDataSource;
    }
    @Bean
    public static JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(JDBCConfig.druidDataSource());
        return  jdbcTemplate;
    }

}