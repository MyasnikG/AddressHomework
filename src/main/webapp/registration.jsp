<%--
  Created by IntelliJ IDEA.
  User: miasn
  Date: 4/22/2023
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>

<form method="post" action="/registration">

    name: <input type="text" name="name"><br><br>
    surname: <input type="text" name="surname"><br><br>
    age: <input type="text" name="age"><br><br>
    email: <input type="text" name="email"><br><br>
    password <input type="text" name="password"><br><br>

    <input type="submit" name="submit"><br><br>
</form>
</body>
</html>
