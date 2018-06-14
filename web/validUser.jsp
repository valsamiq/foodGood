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
        <%String status = (String) request.getAttribute("status");
            User u = (User) session.getAttribute("user");
            String username = u.getName();
            int type = u.getType();
        %>
        <h3>Welcome, <%=username%></h3>
        <% if (type == 1) { %>
        UserType=Admin
        <form action="altaRestaurante.html">
            <input type="submit" value="Nuevo Restaurante">
        </form>
        <%  } else {%>
        UserType=User
        <%}%>
        <form action="index.html">
            <input type="submit" value="Menu Principal"/>
        </form>
    </body>
</html>