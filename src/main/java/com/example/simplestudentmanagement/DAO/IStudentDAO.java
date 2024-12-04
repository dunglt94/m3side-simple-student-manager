package com.example.simplestudentmanagement.DAO;

import com.example.simplestudentmanagement.model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> findAll();

    void creat(Student student);

    Student findById(int id);

    void update(int id, Student student);

    void delete(int id);

    Student findByName(int id);
}
