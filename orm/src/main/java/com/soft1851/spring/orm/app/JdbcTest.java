package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.config.JDBCConfig;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/19
 **/
@ComponentScan("")
public class JdbcTest {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate= JDBCConfig.jdbcTemplate();
        String sql = "SELECT * FROM t_forum";
        System.out.println(jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Forum.class)));
    }
}