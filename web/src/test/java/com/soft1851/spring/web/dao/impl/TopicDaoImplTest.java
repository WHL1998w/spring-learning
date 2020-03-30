package com.soft1851.spring.web.dao.impl;


import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.dao.TopicDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicDaoImplTest {

    @Autowired
    private TopicDao topicDao;
    @Test
    public  void  selectAll(){
        System.out.println(topicDao.selectAll());
    }


}