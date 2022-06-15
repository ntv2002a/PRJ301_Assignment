<%-- 
    Document   : CircleTest
    Created on : May 30, 2022, 3:12:26 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
    <c:if test="${requestScope.circle ne null}">
            <table border="1" cellpadding="3" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>X</th>
                <th>Y</th>
                <th>Radius</th>
            </tr>
            
            <tr>
                <td>${requestScope.circle.getId()}</td>
                <td>${requestScope.circle.getX()}</td>
                <td>${requestScope.circle.getY()}</td>
                <td>${requestScope.circle.getRadius()}</td>
            </tr>
            </table>
        </c:if>        
    </body>
</html>
