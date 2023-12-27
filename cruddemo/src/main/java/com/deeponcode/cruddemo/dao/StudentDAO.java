package com.deeponcode.cruddemo.dao;

import com.deeponcode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findAllOrderByLastName();
    List<Student> findByLAstName(String theLastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}
