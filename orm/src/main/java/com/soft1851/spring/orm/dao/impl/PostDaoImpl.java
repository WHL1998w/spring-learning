package com.soft1851.spring.orm.dao.impl;
import com.soft1851.spring.orm.dao.PostDao;
import com.soft1851.spring.orm.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName PostDaoImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/17
 **/

@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
    }

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        Object[] args = {post.getForumId(),post.getTitle(),post.getContent(),post.getThumbnail(),post.getCreateTime()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,NULL,NULL)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postList.get(i).getForumId());
                preparedStatement.setString(2,postList.get(i).getTitle());
                preparedStatement.setString(3,postList.get(i).getContent());
            }
            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchDelete(int [] postIds) {
        final int[] postIds1 = postIds;
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postIds1[i]);
            }

            @Override
            public int getBatchSize() {
                return postIds1.length;
            }
        });
    }

    @Override
    public Post getBypostId(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post>  getBykeywords(String keywords) {
        String sql = "SELECT * FROM t_post WHERE title LIKE '%"+keywords+"%' OR content LIKE '%" +keywords+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class));
    }


    @Override
    public int countPostByForumId(int forumId) {

        String sql = "SELECT * FROM t_post WHERE  forum_id="+forumId;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class)).size();
    }
}