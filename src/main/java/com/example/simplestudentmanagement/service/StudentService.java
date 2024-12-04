package com.example.simplestudentmanagement.service;

import com.example.simplestudentmanagement.DAO.IStudentDAO;
import com.example.simplestudentmanagement.DAO.StudentDAO;
import com.example.simplestudentmanagement.model.Student;

import java.util.List;


public class StudentService implements IStudentService {
    IStudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public void create(Student student) {
        studentDAO.creat(student);
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void remove(int id) {
        studentDAO.delete(id);
    }

    @Override
    public List<Student> findByName(int id) {
        return null;
    }
}
