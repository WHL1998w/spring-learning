package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.BookDao;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Override
    public int[] batchInsert(List<Book> books) {
        return bookDao.batchInsert(books);
    }

    @Override
    public List<Book> queryAll() {
        return bookDao.selectAll();
    }
}