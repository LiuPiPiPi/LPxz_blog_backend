package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.Student;
import com.lpxz.lpxzblog.entity.Teacher;

import java.util.List;

public interface StudentMapper {
    // 按查询嵌套处理
    List<Student> getStudents();

    // 按结果嵌套处理
    List<Student> getStudents2();

    Teacher getTeacherById(int id);

    List<Student> getStudentsByTeacher(int id);
}
