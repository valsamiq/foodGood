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
        <title>DishList</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        //String status=(String) request.getAttribute("status");
        List<Dish> allDishes=(List<Dish>) request.getAttribute("allDish");
        %>
        <table>
                <% for (Dish ad : allDishes) { %>
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