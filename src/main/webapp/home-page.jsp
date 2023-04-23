<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: miasn
  Date: 4/22/2023
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<%
    String userInfo = (String) request.getAttribute("userInfo");
    String addressInfo = (String) request.getAttribute("addressInfo");
    PrintWriter writer = response.getWriter();
    if (userInfo != null) {
        writer.println(userInfo + "<br><br>");
    }
    if (addressInfo != null) {
        writer.print(addressInfo);
    }
%>
</body>
<br><br>

<a href="/address.jsp">Add Address</a><br><br>
</html>
