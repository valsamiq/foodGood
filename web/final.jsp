<%-- 
    Document   : final
    Created on : 13-jun-2018, 10:54:33
    Author     : daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User Final</title>
    </head>
    <body>
        <%
        String status = (String) request.getAttribute("status");
        if (status != null) {
            %>
            <h1><%= status %></h1>
            <form action="login.html">
                <input type="submit" value="Logueate"/>
            </form>
            <form action="index.html">
            <input type="submit" value="Menu Principal"/>
        </form>
            <%
        }
        %>
    </body>
</html>
