package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @InterfaceName BookService
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
public interface BookService {
    /**
     * 批量增加
     * @param books
     * @return
     */

    int[] batchInsert(List<Book> books);
    /**
     * 查询所有
     * @return
     */
    List<Book> queryAll();

}
