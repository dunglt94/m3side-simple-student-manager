<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student list</title>
    <style>
        table {
            border-collapse: collapse;
            box-shadow:  0 0 5px 2px rgba(89,155,214,69);
        }

        th {
            padding: 10px;
        }

        td {
            border-bottom: 1px solid black;
            padding: 10px;
            text-align: left;
        }

        .photo, .score {
            text-align: center;
        }

        img {
            width: 45px;
            height: 45px;
        }

        a {
            text-decoration: none;
            collapse: black;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Students</h2>
    <form action="students" method="get">
        <p>
            <label for="search"></label>Search:
            <input type="hidden" name="action" value="search">
            <input type="text" name="name" id="search" placeholder="Student Name">
            <input type="submit" value="Search">
        </p>
    </form>
    <p>
        <a href="${pageContext.request.contextPath}/students?action=add">Create new student</a>
    </p>
    <table>
        <tr>
            <th>Name</th>
            <th>Score</th>
            <th>Photo</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>
                    <a href="students?action=view&id=${student.getId()}">${student.getName()}</a>
                </td>
                <td class="score">${student.getScore()}</td>
                <td class="photo">
                    <img src="${student.getPhoto()}" alt="photo">
                </td>
                <td><a href="students?action=edit&id=${student.getId()}">edit</a></td>
                <td><a href="students?action=delete&id=${student.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
