package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.BookDao;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Rank;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
@Repository
public class BookDaoImpl implements BookDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> selectAll() {
        String sql="SELECT * FROM t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public int[] batchInsert(List<Book> books) {
        final List<Book> bookList=books;
        String sql="INSERT INTO t_book(title, `desc`, username, profile, price, img) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Book book =bookList.get(i);
                preparedStatement.setString(1,book.getTitle());
                preparedStatement.setString(2,book.getDesc());
                preparedStatement.setString(3,book.getUserName());
                preparedStatement.setString(4,book.getProfile());
                preparedStatement.setDouble(5,book.getPrice());
                preparedStatement.setString(6,book.getImg());
            }

            @Override
            public int getBatchSize() {
                return bookList.size();
            }
        });
    }

    @Override
    public int[] batchDelete(int[] id) {
        final int[] ids = id;
        String sql = "DELETE FROM t_book WHERE id = ?";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,ids[i]);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
    }
}