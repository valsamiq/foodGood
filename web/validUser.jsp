<%--
    Document   : validUser
    Created on : 12-jun-2018, 13:35:36
    Author     : daw2
--%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion de usuario</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
        %>
            <h1>Welcome, <%=username%>!</h1>
        <form action="index.html">
            <input type="submit" value="Menu Principal"/>
        </form>
    </body>
</html>