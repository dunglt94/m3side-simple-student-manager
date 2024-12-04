package com.example.simplestudentmanagement.DAO;

import com.example.simplestudentmanagement.model.Class;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO {
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcUsername = "root";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcPassword = "123456";

    private static final String SELECT_ALL_CLASSES = "SELECT * FROM classes;";

    public ClassDAO() {}

    private Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
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
    public List<Class> findAllClasses() {
        List<Class> classes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSES);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Class newClass = new Class();
                newClass.setId(resultSet.getInt("id"));
                newClass.setName(resultSet.getString("name"));
                classes.add(newClass);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return classes;
    }
}
