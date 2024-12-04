package com.example.simplestudentmanagement.DAO;

import com.example.simplestudentmanagement.model.Class;

import java.util.List;

public interface IClassDAO {
    List<Class> findAllClasses();
}
