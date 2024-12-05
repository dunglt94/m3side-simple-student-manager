package com.example.simplestudentmanagement.controller;

import com.example.simplestudentmanagement.model.Student;
import com.example.simplestudentmanagement.model.Class;
import com.example.simplestudentmanagement.service.ClassService;
import com.example.simplestudentmanagement.service.IClassService;
import com.example.simplestudentmanagement.service.IStudentService;
import com.example.simplestudentmanagement.service.StudentService;

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
    IStudentService studentService = new StudentService();
    IClassService classService = new ClassService();

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
                creatStudent(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
        }
    }

    private void creatStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int score = Integer.parseInt(req.getParameter("score"));
        String photo = req.getParameter("photo");
        int classId = Integer.parseInt(req.getParameter("classId"));

        Student student = new Student(name, score, photo, classId);
        studentService.create(student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        req.setAttribute("message", "New student added");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int score = Integer.parseInt(req.getParameter("score"));
        String photo = req.getParameter("photo");
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            student.setId(id);
            student.setName(name);
            student.setScore(score);
            student.setPhoto(photo);
            student.setClassId(classId);
            studentService.update(student);
            req.setAttribute("student", student);
            req.setAttribute("message", "Student information was updated");
            dispatcher = req.getRequestDispatcher("student/edit.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            studentService.remove(id);
            try {
                resp.sendRedirect("/students");
            } catch (IOException e) {
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
            }
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
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
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
        List<Class> classes = classService.findAllClasses();
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("student", student);
            req.setAttribute("classes", classes);
            dispatcher = req.getRequestDispatcher("student/view.jsp");
        }
        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("student/edit.jsp");
        }
        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("student/delete.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Student> students = studentService.findAll();
        List<Class> classes = classService.findAllClasses();
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredStudents.add(student);
            }
        }
        req.setAttribute("students", filteredStudents);
        req.setAttribute("classes", classes);
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
        List<Class> classes = classService.findAllClasses();
        req.setAttribute("students", students);
        req.setAttribute("classes", classes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");

        try{
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
