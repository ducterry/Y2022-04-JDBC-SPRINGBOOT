package com.ndangducbn.jdbc.service.impl;

import com.ndangducbn.jdbc.bean.Student;
import com.ndangducbn.jdbc.dao.StudentDao;
import com.ndangducbn.jdbc.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int createStudent(Student student) {
        return this.studentDao.createStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return this.studentDao.update(student);
    }

    @Override
    public int deleteBySno(String sno) {
        return this.studentDao.deleteBySno(sno);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        return this.studentDao.queryStudentsListMap();
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentDao.queryStudentBySno(sno);
    }
}
