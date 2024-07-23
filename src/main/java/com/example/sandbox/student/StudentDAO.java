package com.example.sandbox.student;

import java.util.List;

public interface StudentDAO {
    void save(Student st);

    Student findById(long id);

    List<Student> findAll();

    List<Student> findByLastname(String lastname);

    void update(Student student);

    void delete(Student student);

    int deleteAll();
}
