package com.soft1851.spring.orm.dao;
import com.soft1851.spring.orm.entity.Post;

import java.util.List;

/**
 * @ClassName PostDao
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/17
 **/
public interface PostDao {
    /**
     * 新增Post
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量增加Post
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);


    /**
     * 根据postId删除
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 批量删除Post
     * @param postIds
     * @return
     */

    int[] batchDelete(int [] postIds);

    /**
     * 根据id查询Post
     * @param postId
     * @return
     */
    Post getBypostId(int postId);

    /**
     * 根据关键字查询Post
     * @param keywords
     * @return
     */
   List<Post>  getBykeywords(String keywords);

    /**
     * 统计某个论坛的帖子总数
     * @param forumId
     * @return
     */

    int countPostByForumId(int forumId);


}
