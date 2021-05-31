package org.example.jdbc.dao;

import org.example.Student;

public interface StudentDao {
    public int insert(Student student);

    public int update(Student student);
}
