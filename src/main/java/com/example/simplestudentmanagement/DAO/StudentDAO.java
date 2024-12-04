package com.example.simplestudentmanagement.DAO;

import com.example.simplestudentmanagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcUsername = "root";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcPassword = "123456";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String INSERT_STUDENT = "INSERT INTO students " +
            "(name, score, photo, class_id) VALUES (?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE students " +
            "SET name = ?, score = ?, photo = ?,  class_id WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private static final String SELECT_STUDENT_BY_NAME = "SELECT * FROM students WHERE name = ?";

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
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getInt("score"));
                student.setPhoto(resultSet.getString("photo"));
                student.setClassId(resultSet.getInt("class_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void creat(Student student) {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            String name = student.getName();
            int score = student.getScore();
            String photo = student.getPhoto();
            int classId = student.getClassId();

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, photo);
            preparedStatement.setInt(4, classId);
            preparedStatement.executeUpdate();

            System.out.println(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                String photo = resultSet.getString("photo");
                int classId = resultSet.getInt("class_id");
                student = new Student(name, score, photo, classId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student findByName(int id) {
        return null;
    }
}
