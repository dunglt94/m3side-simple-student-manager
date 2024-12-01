package com.example.simplestudentmanagement.controller;

import com.example.simplestudentmanagement.model.Student;
import com.example.simplestudentmanagement.service.StudentService;
import com.example.simplestudentmanagement.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Thiết lập encoding cho request
        req.setCharacterEncoding("UTF-8");
        // Thiết lập encoding cho response
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addStudent(req, resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":
                searchStudent(req, resp);
                break;
            default:
        }
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int score = Integer.parseInt(req.getParameter("score"));
        String photo = req.getParameter("photo");

        Student student = new Student(name, score, photo);
        studentService.add(student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/add.jsp");
        req.setAttribute("message", "New student added");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Thiết lập encoding cho request
        req.setCharacterEncoding("UTF-8");
        // Thiết lập encoding cho response
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(req, resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "view":
                viewStudent(req, resp);
                break;
            case "search":
                searchStudent(req, resp);
                break;
            default:
                showList(req, resp);

        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/add.jsp");
        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void viewStudent (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("student/view.jsp");
        }
        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Student> students = studentService.findAll();
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredStudents.add(student);
            }
        }
        req.setAttribute("students", filteredStudents);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/search.jsp");

        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");

        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
