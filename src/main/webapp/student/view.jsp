<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student detail</title>
</head>
<body>
<h3>Student detail</h3>
<p>
    <a href="${pageContext.request.contextPath}/students">Back to student list</a>
</p>
<table>
    <tr>
        <td>Photo: </td>
        <td>
            <img src="${student.getPhoto()}" alt="photo" style="width: 50px; height: 50px">
        </td>
    </tr>
    <tr>
        <td>id: </td>
        <td>${student.getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${student.getName()}</td>
    </tr>
    <tr>
        <td>Score: </td>
        <td>${student.getScore()}</td>
    </tr
    ><tr>
        <td>Class Id: </td>
        <td>${student.getClassId()}</td>
    </tr>
</table>
</body>
</html>
