<%-- 
    Document   : dishList
    Created on : 14-jun-2018, 11:37:31
    Author     : daw2
--%>

<%@page import="entities.Dish"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dish List</title>
    </head>
    <body>
        <h1>Lista de Platos</h1>
        <%
        String status=(String) request.getAttribute("status");
        List<Dish> filtDish=(List<Dish>) request.getAttribute("filtDish");
        %>
        <table>
                <% for (Dish ad : filtDish) { %>
                <tr>
                    <td><%=ad.getName()%></td>
                    <td><%=ad.getType()%></td>
                    <td><%=ad.getPrice()%></td>
                    <td><%=ad.getRestaurant().getName()%></td>
                </tr>
                <% }%>
        </table>
        <form action="index.html">
            <input type="submit" value="Menu Principal"/>
        </form>
    </body>
</html>