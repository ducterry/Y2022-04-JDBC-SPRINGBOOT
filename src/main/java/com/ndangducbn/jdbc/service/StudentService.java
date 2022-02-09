package com.ndangducbn.jdbc.service;

import com.ndangducbn.jdbc.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int createStudent(Student student);
    int updateStudent(Student student);
    int deleteBySno(String sno);
    List<Map<String,Object>> queryStudentsListMap();
    Student queryStudentBySno(String sno);
}
