package com.example.simplestudentmanagement.service;

import com.example.simplestudentmanagement.DAO.ClassDAO;
import com.example.simplestudentmanagement.DAO.IClassDAO;
import com.example.simplestudentmanagement.model.Class;

import java.util.List;

public class ClassService implements IClassService {
    IClassDAO classDAO = new ClassDAO();

    @Override
    public List<Class> findAllClasses() {
        return classDAO.findAllClasses();
    }
}
