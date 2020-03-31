package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.ClazzVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzVoMapperTest {

    @Resource
    private ClazzVoMapper clazzVoMapper;
    @Test
    public void getClazzStudent1() {
        List<Map<String,Object>> clazzVo = clazzVoMapper.getClazzStudent1(2);
        clazzVo.forEach(System.out::println);

    }

    @Test
    public void getClazzStudent() {
        List<ClazzVo> clazzVos = clazzVoMapper.getClazzStudent(1);
        clazzVos.forEach(System.out::println);
    }
}