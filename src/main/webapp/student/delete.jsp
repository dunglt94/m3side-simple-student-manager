<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete student</title>
</head>
<body>
<h1>Delete student</h1>
<p>
    <a href="students">Back to student list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["student"].getName()}</td>
            </tr>
            <tr>
                <td>Score: </td>
                <td>${requestScope["student"].getScore()}</td>
            </tr>
            <tr>
                <td>Photo: </td>
                <td>
                    <img src="${requestScope["student"].getPhoto()}" style="width: 60px; height: 60px"
                         alt="Ảnh của ${requestScope["student"].getName()}">
                </td>
            </tr>
            <tr>
                <td>Class Id: </td>
                <td>${requestScope["student"].getClassId()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
