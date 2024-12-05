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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://static.topcv.vn/company_logos/0ZT9refQobeAkpzsYWBdyaki10IlbFB4_1655288503____f48c9fc932b36c4eec44ec23d223fa18.png"
                     alt="logo" class="img-fluid" style="max-height: 50px">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="http://localhost:8080/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/students">Student Management</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="col-sm-3 col-md-3 col-lg-3">
        <h2>Student detail</h2>
        <table class="table table-hover align-middle text-center">
            <tr>
                <td>Photo: </td>
                <td>
                    <img src="${student.getPhoto()}" alt="photo">
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
            <td>Class: </td>
            <td>
                <c:forEach var="clazz" items="${classes}">
                    <c:if test="${student.classId == clazz.id}">
                        ${clazz.name}
                    </c:if>
                </c:forEach>
            </td>
        </tr>
        </table>
        <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Back</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
