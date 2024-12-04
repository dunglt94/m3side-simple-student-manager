package com.example.simplestudentmanagement.service;

import com.example.simplestudentmanagement.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void create(Student student);

    Student findById(int id);

    void update(Student student);

    void remove(int id);

    List<Student> findByName(String name);
}
