<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 04/03/2020
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../jsFile/check.js" type="text/javascript"></script>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
        <p>
            <c:if test='${requestScope["message"] !=null}'>
                ${requestScope["message"]}
            </c:if>
        </p>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Search User
                </h2>
            </caption>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15" value="${country}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Search" onclick="checkkitu()"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
