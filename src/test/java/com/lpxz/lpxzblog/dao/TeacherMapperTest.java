package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.Teacher;
import com.lpxz.lpxzblog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TeacherMapperTest {
    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teacherList = mapper.getTeacher();

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetTeacherById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacherById(1);

        System.out.println(teacher);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetTeacherById2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacherById2(1);

        System.out.println(teacher);

        sqlSession.commit();
        sqlSession.close();
    }
}
