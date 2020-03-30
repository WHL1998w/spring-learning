package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.spider.BiLiBiLiSpider;
import com.soft1851.spring.web.spider.JueJinBookSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class BookServiceTest {

    @Resource
    private BookService bookService;
    @Test
    public void batchInsert() {
        int [] ints=bookService.batchInsert(JueJinBookSpider.getBooks());
        assertEquals(JueJinBookSpider.getBooks().size(),ints.length);

    }
}