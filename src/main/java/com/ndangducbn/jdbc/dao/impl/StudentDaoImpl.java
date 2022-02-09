package com.ndangducbn.jdbc.dao.impl;

import com.ndangducbn.jdbc.bean.Student;
import com.ndangducbn.jdbc.dao.StudentDao;
import com.ndangducbn.jdbc.mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createStudent(Student student) {
        DataSource dataSource = this.jdbcTemplate.getDataSource();
        String sql = "INSERT INTO STUDENT(SNO,SNAME,SSEX) VALUES(:sno,:name,:sex)";
        NamedParameterJdbcTemplate namedParameter = new NamedParameterJdbcTemplate(dataSource);
        return namedParameter.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE STUDENT SET SNAME=?, SSEX=? WHERE SNO =?";
        Object[] fields = {student.getName(), student.getSex(), student.getSno()};
        int[] fieldTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, fields, fieldTypes);
    }

    @Override
    public int deleteBySno(String sno) {
        String sql = "DELETE FROM STUDENT WHERE SNO =?";
        Object[] fields = {sno};
        int[] fieldTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, fields, fieldTypes);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        String sql = "SELECT * FROM STUDENT";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        String sql = "SELECT * FROM STUDENT WHERE SNO=?";
        Object[] fields = {sno};
        int[] fieldTypes = {Types.VARCHAR};
        List<Student> studentList = this.jdbcTemplate.query(sql, fields, fieldTypes, new StudentMapper());
        if (!studentList.isEmpty()) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
