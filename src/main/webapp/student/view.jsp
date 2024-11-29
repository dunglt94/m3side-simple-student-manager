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
    <style>
        table {

            border-collapse: collapse;
            box-shadow:  0 0 5px 2px rgba(89,155,214,69);
        }

        th {
            padding: 10px;
        }

        td {
            font-weight: bold;
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }


    </style>
</head>
<body>
<h3>Student detail</h3>
<table>
    <tr>
        <td>Photo: </td>
        <td>
            <img src="${requestScope["student"].getPhoto()}" alt="photo" style="width: 50px; height: 50px">
        </td>
    </tr>
    <tr>
        <td>id: </td>
        <td>${requestScope["student"].getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
    </tr>
    <tr>
        <td>Score: </td>
        <td>${requestScope["student"].getScore()}</td>
    </tr>
</table>
</body>
</html>
