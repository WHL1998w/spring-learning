package com.soft1851.spring.orm.dao.impl;
import com.soft1851.spring.orm.dao.PostDao;
import com.soft1851.spring.orm.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoImplTest {
    @Autowired
    private PostDao postDao;
    @Test
    public void insert() {
        Post post=Post.builder().forumId(2).title("打开").content("第一首原创").build();
        int n = postDao.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        Post[] forums =
                {Post.builder().forumId(3).title("测试论坛1").content("123").build(),
                Post.builder().forumId(3).title("测试论坛2").content("123").build(),
                Post.builder().forumId(3).title("测试论坛3").content("123").build(),
        } ;
        List<Post> forumList = Arrays.asList(forums);
        int[] rows = postDao.batchInsert(forumList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n=postDao.delete(2);
        assertEquals(1,n);
    }

    @Test
    public void batchDelete() {
        int[] tem = {5,6};
        int[] rows = postDao.batchDelete(tem);
        assertEquals(2,rows.length);
    }

    @Test
    public void get() {
        Post post=postDao.getBypostId(1);
        assertNotNull(post);
    }

    @Test
    public void testGet() {
        List<Post> postList = postDao.getBykeywords("第一");
        postList.forEach(item -> System.out.println(item.getPostId()));
    }

    @Test
    public void countPostByForumId() {
        int n = postDao.countPostByForumId(1);
        System.out.println(n);
    }
}