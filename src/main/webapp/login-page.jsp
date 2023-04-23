<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: miasn
  Date: 4/22/2023
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form method="get" action="/login">

    <%
        PrintWriter writer = response.getWriter();
        String message = (String) request.getAttribute("errorMessage");
        if(message!=null){
            writer.print(message);
        }
    %>

    username: <input type="text" name="username"><br><br>
    password: <input typr="text" name="password"><br><br>

    <input type="submit" name="submit">
</form>
</body>

<a href="/registration.jsp">registration</a><br><br>
<a href="/forgot-password.jsp">forgot password</a><br><br>

</html>
