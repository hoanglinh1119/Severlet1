<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
  .login{
  height: 300px;
    width: 400px;
    padding: 5px;
    border: solid 2px magenta;
    text-align: center;
      margin-left: auto;
      margin-right: auto;
  }
  .input{
    height: 50px;
    width: 200px;
    padding: 5px;
    border: #7226ff solid 3px;
  }
  .form ul li {
      list-style: none;
      padding: 10px;
  }
  .sign{
    height: 25px;
    width: 50px;
  }
</style>
  <head>
    <title></title>
  </head>
  <body>
   <div class="login">
     <form class="form" method="post" action="login">
         <ul>
         <li><h2>Login</h2></li>
             <li><a>Username:  </a><input class="input" type="text" name="Username" placeholder="username"></li>
             <li><a>Password:  </a><input  class="input" type="password" name="Password" placeholder="password"></li>
             <li><input class="sign" type="submit" value="Sign in" ></li>
         </ul>
     </form>
   </div>
  </body>
</html>