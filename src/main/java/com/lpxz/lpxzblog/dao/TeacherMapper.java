package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.Student;
import com.lpxz.lpxzblog.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    // 按照结果嵌套处理
    Teacher getTeacherById(@Param("tId") int id);

    // 按照查询嵌套处理
    Teacher getTeacherById2(@Param("tId") int id);

    List<Student> getStudentByTeacher(@Param("tId") int id);
}
