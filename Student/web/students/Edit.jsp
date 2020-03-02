<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 02/03/2020
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/students">Back to student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
            <td>Name: </td>
            <td><input type="text" name="name" id="name" value="${requestScope["students"].getName()}"></td>
            </tr>
            <tr>
                <td>Gender: </td>
                <td><input type="text" name="gender" id="gender" value="${requestScope["students"].getGender()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["students"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Number Phone: </td>
                <td><input type="text" name="number" id="number" value="${requestScope["students"].getNumberPhone()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope["students"].getAddress()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
