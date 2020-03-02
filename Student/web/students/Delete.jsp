<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 02/03/2020
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
    <title>Deleting student</title>
   </head>
   <body>
   <h1>Delete student</h1>
   <p>
       <a href="/students">Back to student list</a>
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
                   <td>Gender: </td>
                   <td>${requestScope["student"].getGender()}</td>
               </tr>
               <tr>
                   <td>Email: </td>
                   <td>${requestScope["student"].getEmail()}</td>
               </tr>
               <tr>
                   <td>Number Phone: </td>
                   <td>${requestScope["student"].getNumberPhone()}</td>
               </tr>
               <tr>
                   <td>Address: </td>
                   <td>${requestScope["student"].getAddress()}</td>
               </tr>
               <tr>
                   <td><input type="submit" value="Delete student"></td>
                   <td><a href="/students">Back to student list</a></td>
               </tr>
           </table>
       </fieldset>
   </form>
   </body>

</html>
