<%-- 
    Document   : dishList
    Created on : 14-jun-2018, 11:37:31
    Author     : daw2
--%>

<%@page import="beans.FoodEJB"%>
<%@page import="entities.Dish"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Dish List</title>
    </head>
    <body>
        <% List<Dish> allDishes= (List<Dish>) request.getAttribute("allDish"); %>
        <form method="POST" action="VerPlato">
            <p>Selecciona Tipo
                <select name="typs">
                    <option value="all" name="typs">All</option>
                    <% for (Dish d : allDishes) { %>
                        <option value="<%=d.getType()%>" name="typs"><%=d.getType()%></option>
                    <% }%>
                </select>
            </p>
            <p><input type="submit" value="Seleccionar"></p>
        </form>
        <form action="index.html">
            <input type="submit" value="Menu Principal"/>
        </form>
    </body>
</html>