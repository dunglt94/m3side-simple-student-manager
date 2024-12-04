<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Searched Students</title>
</head>
<body>
<h2>Searched Students</h2>
<form action="students" method="get">
    <p>
        <label for="search"></label>Search:
        <input type="hidden" name="action" value="search">
        <input type="text" name="name" id="search" placeholder="Student Name">
        <input type="submit" value="Search">
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/students">Back to student list</a>
</p>
<table>
    <tr>
        <th>Name</th>
        <th>Score</th>
        <th>Photo</th>
        <th>Class ID</th>
        <th colspan="2">Action</th>

    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>
                <a href="students?action=view&id=${student.getId()}">${student.getName()}</a>
            </td>
            <td>${student.getScore()}</td>
            <td>
                <img src="${student.getPhoto()}" alt="photo">
            </td>
            <td>${student.getClassId()}</td>
            <td><a href="students?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="students?action=delete&id=${student.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>