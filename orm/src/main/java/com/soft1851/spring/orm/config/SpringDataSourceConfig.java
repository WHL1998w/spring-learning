package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.dao.PostDao;
import com.soft1851.spring.orm.dao.impl.ForumDaoImpl;
import com.soft1851.spring.orm.dao.impl.PostDaoImpl;
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
public class SpringDataSourceConfig {
    /**
     * 数据连接地址池配置
     * @return
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_bbs?useSSL=false&serverTimezone=UTC&Unicode=true" +
                "&characterEncoding=utf-8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(8);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    @Bean
    public ForumDao forumDao(JdbcTemplate jdbcTemplate){
        return new ForumDaoImpl(jdbcTemplate);
    }
    @Bean
    public PostDao postDao(JdbcTemplate jdbcTemplate){
        return new PostDaoImpl(jdbcTemplate);
    }

}
