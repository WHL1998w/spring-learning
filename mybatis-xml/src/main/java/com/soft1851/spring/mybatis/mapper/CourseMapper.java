package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @InterfaceName CourseMapper
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
public interface CourseMapper {
    /**
     * 根据班课id查询班课详情
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
