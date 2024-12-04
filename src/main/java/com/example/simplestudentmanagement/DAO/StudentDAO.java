package com.example.simplestudentmanagement.DAO;

import com.example.simplestudentmanagement.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcURL = "jdbc:mysql://localhost:3306/demousermanagement";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcUsername = "root";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcPassword = "123456";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
    private static final String INSERT_STUDENT = "INSERT INTO student VALUES (?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE student " +
            "SET name = ?, score = ?, photo = ?,  class_id WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?";
    private static final String SELECT_STUDENT_BY_NAME = "SELECT * FROM student WHERE name = ?";

    public StudentDAO() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void creat(Student student) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student findByName(int id) {
        return null;
    }
}
