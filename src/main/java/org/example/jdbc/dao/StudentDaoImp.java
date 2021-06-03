package org.example.jdbc.dao;

import org.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImp implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String query = "insert into student (id,name,city) values (?,?,?)";
        int update = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return update;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=?, city=? where id=?";
        int update = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return update;
    }

    @Override
    public int delete(int studentId) {
        String query = "delete from student where id=?";
        int delete = jdbcTemplate.update(query,studentId);
        return delete;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        RowMapper<Student> studentRowMapper = new RowMapperImp();
        Student student = jdbcTemplate.queryForObject(query, studentRowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student> students = jdbcTemplate.query(query, new RowMapperImp());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
