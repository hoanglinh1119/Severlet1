<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 27/02/2020
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="index.css">
  </head>
  <body>
    <div class="all">
      <h2 class="head"> Curency conventer</h2>
      <form class="form" method="post" action="convert">
        <ul>
          <li><a>Rate :</a> <input type="text"  name="rate" value="22000" placeholder="Rate"></li>
          <li><a>USD :</a> <input name="usd" type="text" value="1" placeholder="usd"></li>
          <li> <input type="submit" value="coventer" id="submit"></li>
        </ul>
      </form>

    </div>
  </body>
</html>
