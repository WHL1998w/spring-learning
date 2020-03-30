//package com.soft1851.spring.web.dao;
//
//import com.soft1851.spring.web.entity.Forum;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
//public class ForumDaoTest {
//
//    @Autowired
//    private ForumDao forumDao;
//    @Test
//    public void delete() {
//        int n=forumDao.delete(1);
//        assertEquals(1,n);
//    }
//
//    @Test
//    public void get() {
//        Forum forum=forumDao.get(3);
//        assertNotNull(forum);
//    }
//
//    @Test
//    public void selectAll() {
//        List<Forum> forums=forumDao.selectAll();
//        assertEquals(12,forums.size());
//    }
//}