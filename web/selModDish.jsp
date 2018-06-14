<%-- 
    Document   : selModList
    Created on : 14-jun-2018, 15:37:36
    Author     : daw2
--%>

<%@page import="entities.Dish"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Price</title>
    </head>
    <body>
        <h1>Modificar precio</h1>
        <% List<Dish> allDishs=(List<Dish>) request.getAttribute("allDish"); %>
        <form method="POST" action="ModDishPrice">
            <p>Select to modify <select name="name">
                    <% for (Dish d : allDishs) { %>
                    <option value="<%=d.getName()%>" name="name"><%=d.getName()%></option>
                    <% }%>
                </select>
            </p>
            <p>Precio: <input type="number" name="price" min="0" required></p>
            <p><input type="submit" value="Modificar"></p>
        </form>
    </body>
</html>