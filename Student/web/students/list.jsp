<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 02/03/2020
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Student</h1>
<p>
    <a href="students?action=create">Create new Student</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td> Student ID</td>
        <td> Gender</td>
        <td>Email</td>
        <td> Number Phone</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
        <td>View</td>
    </tr>
    <c:forEach items='${requestScope["students"]}' var="student">
        <tr>
            <td><a href="students?action=view&id=${student.getId()}">${student.getName()}</a></td>
            <td>${student.getId()}</td>
            <td>${student.getGender()}</td>
            <td>${student.getEmail()}</td>
            <td>${student.getNumberPhone()}</td>
            <td>${student.getAddress()}</td>
            <td><a href="students?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="students?action=delete&id=${student.getId()}">delete</a></td>
            <td><a href="students?action=view=${student.getId()}">view</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
