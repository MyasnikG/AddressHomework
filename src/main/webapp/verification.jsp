<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: miasn
  Date: 4/22/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification Page</title>
</head>
<body>

<form method="post" action="/verification">


    <%
        PrintWriter writer = response.getWriter();
        String verifyCode = (String) request.getAttribute("verify_code");
        if(verifyCode!=null){
            writer.print(verifyCode);
        }
        String message = (String) request.getAttribute("errorMessage");/*again, we are giving key to receive value("Wrong verification code")*/
        if(message!=null){
            writer.print("<html>");
            writer.print(message);
            writer.print("<br><br>");
            writer.print((String)request.getAttribute("verifyCodeDB"));/*if we wrote wrong code, right code will be shown again*/
            writer.print("</html>");
        }
    %>
    verification code: <input type="text" name="verifyCode"><br><br>
    <input type="submit" name="submit">
</form>
</body>
</html>
