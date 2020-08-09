package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.Student;
import com.lpxz.lpxzblog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void testGetStudents() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents();

        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetStudents2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students) {
            System.out.println(
                    "学生名:" + student.getName()
                            + "\t老师:" + student.getTeacher().getName());
        }
    }

    @Test
    public void testGetStudentsByTeacher() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudentsByTeacher(1);

        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
