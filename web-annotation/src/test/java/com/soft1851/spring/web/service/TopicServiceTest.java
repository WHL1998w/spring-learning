package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.spider.JueJinSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicServiceTest {
    @Autowired
    private TopicService topicService;

    @Test
    public void selectAll() {
        System.out.println();
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(),ints.length);
    }

    @Test
    public void insert() {
        Topic topic =   Topic.builder()
                .topicName("111")
                .description("111")
                .topicIcon("111")
                .followersCount(111)
                .msgCount(111)
                .followed(false).build();
        topicService.insert(topic);

    }
}