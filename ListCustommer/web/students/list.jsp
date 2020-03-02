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
    <a href="/students?action=create">Create new Student</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td> ClassId</td>
        <td>Email</td>
        <td> NumberPhone</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["students"]}' var="student">
        <tr>
            <td><a href="/students?action=view&id=${student.getId()}">${students.getName()}</a></td>
            <td>${student.getClassId()}</td>
            <td>${students.getEmail()}</td>
            <td>${students.getNumberPhone()}</td>
            <td>${students.getAddress()}</td>
            <td><a href="/students?action=edit&id=${students.getId()}">edit</a></td>
            <td><a href="/students?action=delete&id=${students.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
