<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/11/2024
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<h1>Edit student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message" style="color: green">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="students">Back to student list</a>
</p>
<form method="post">
    <fieldset style="width: 250px">
        <legend>Student information</legend>
        <table>
            <tr>
                <td><label for="name">Name: </label></td>
                <td><input type="text" name="name" id="name" value="${requestScope["student"].getName()}"></td>
            </tr>
            <tr>
                <td><label for="score">Score: </label></td>
                <td><input type="text" name="score" id="score" value="${requestScope["student"].getScore()}"></td>
            </tr>
            <tr>
                <td><label for="photo">Photo: </label></td>
                <td><input type="text" name="photo" id="photo" value="${requestScope["student"].getPhoto()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
