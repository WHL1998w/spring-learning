package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @InterfaceName StudentMapper
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     * 新增学生，并返回自增主键
     * @param student
     */
    void insert(Student student);

    /**
     * 根据studentId删除学生
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 根据学生的id查询学生
     * @param studentId
     * @return
     */
    Student getStudentById(int studentId);

    /**
     * 更新学生
     * @param student
     */
    void update(Student student);

    /**
     * 批量新增
     * @param students
     * @return
     */
    int batchInsert(@Param("students")List<Student> students);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList") int[] idList);

    /**
     * 单表（带两个指定条件的查询）
     * @return
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态SQL）
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 批量修改
     * @param students
     * @return
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 查询所有学生，按生日排序，多对一已查询学生所在班级信息
     * @return
     */
    List<Student> selectAll();
}
