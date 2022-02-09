package com.ndangducbn.jdbc.controller;

import com.ndangducbn.jdbc.bean.Student;
import com.ndangducbn.jdbc.model.CreateStudentRq;
import com.ndangducbn.jdbc.model.DetailStudentRq;
import com.ndangducbn.jdbc.model.UpdateStudentRq;
import com.ndangducbn.jdbc.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping(value = "create")
    public String createStudent(@RequestBody CreateStudentRq request) {
        Student student = new Student();
        BeanUtils.copyProperties(request, student);

        this.service.createStudent(student);

        return "CREATE STUDENT OK";
    }

    @PostMapping(value = "update")
    public String updateStudent(@RequestBody UpdateStudentRq request) {
        Student student = new Student();
        BeanUtils.copyProperties(request, student);

        this.service.updateStudent(student);

        return "UPDATE STUDENT OK";
    }

    @DeleteMapping(value = "delete")
    public String deleteStudent(@RequestBody DetailStudentRq request) {
        this.service.deleteBySno(request.getSno());

        return "UPDATE STUDENT OK";
    }

    @GetMapping(value = "")
    public List<Map<String, Object>> getAll() {
        return this.service.queryStudentsListMap();
    }

    @PostMapping(value = "detail")
    public Student getStudentBySno(@RequestBody DetailStudentRq request) {
        return this.service.queryStudentBySno(request.getSno());
    }
}
