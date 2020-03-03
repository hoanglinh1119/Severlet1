<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 02/03/2020
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View student</title>
</head>
<body>
<h1>student details</h1>
<p>
    <a href="/students">Back to student list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
    </tr>
    <tr>
        <td>Gender: </td>
        <td>${requestScope["student"].getGender()}</td>
    </tr>
    <tr>
        <td>Number Phone: </td>
        <td>${requestScope["student"].getNumberPhone()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["student"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["student"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
