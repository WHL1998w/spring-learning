package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @InterfaceName BookDao
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
public interface BookDao {
    /**
     * 搜索全部
     * @return
     */
    List<Book> selectAll();
    /**
     * 批量插入
     * @param books
     * @return
     */
    int [] batchInsert(List<Book> books);

    int[] batchDelete(int [] id);
}
