package com.ndangducbn.jdbc.dao;


import com.ndangducbn.jdbc.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface StudentDao {
	int createStudent(Student student);
    int update(Student student);
    int deleteBySno(String sno);
    List<Map<String,Object>> queryStudentsListMap();
    Student queryStudentBySno(String sno);
}
