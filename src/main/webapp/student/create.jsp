<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add student</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Add new student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/students">Back to student list</a>
</p>
<form method="post">
    <fieldset style="width: 20%">
        <legend>Student information</legend>
        <table>
            <tr>
                <td><label for="name">Name: </label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td><label for="score">Score: </label></td>
                <td><input type="text" name="score" id="score"></td>
            </tr>
            <tr>
                <td><label for="photo">Photo: </label></td>
                <td><input type="text" name="photo" id="photo"></td>
            </tr>
            <tr>
                <td><label for="class_id">Class Id: </label></td>
                <td><input type="text" name="classId" id="class_id"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add Student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
