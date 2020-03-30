package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
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
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void batchDelete() {
        int[] tem = {1,40};
        int[] rows = bookDao.batchDelete(tem);
        assertEquals(2,rows.length);
    }
}