package org.example.jdbc.dao;

import org.example.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImp implements StudentDao {

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

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
