<%-- 
    Document   : groupAttendance
    Created on : Jul 17, 2022, 8:38:44 PM
    Author     : trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                margin-top:20px;
                margin-left: 10%;
                margin-right: 10%;
                font-family: Arial;
            }
            table{
                width: 100%;
            }
            table th{
                height: 60px;
                width: 100px;
                background-color: #f1cfa8;
            }
            table td{
                text-align: center;
                height: 50px;
                width: 100px;
                background-color: #f3e2cf;
            }
            #note1 {
                margin: 10px 10px;
            }
        </style>
    </head>
    <body>
        <h1>
            Take Attendance
        </h1>
        <h2>Group: ${requestScope.group.getName()}</h2>
        <form action="attendance" method="POST">
            <table border="1px solid black">
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Code</th>
                    <th>Image</th>
                    <th>Status</th>
                    <th>Note</th>
                </tr>

                <c:forEach items="${requestScope.group.getStudents()}" var="gs" varStatus="loop">
                    <tr>
                    <input type="hidden" value="${loop.count}" name="count">
                        <td>${loop.count}</td>
                        <td>${gs.getFullname()}</td>
                        <td>${gs.getId()}</td>
                    <input type="hidden" value="${gs.getId()}" name="id_${loop.count}">
                    <td><img src="image/${gs.getId()}.jpg" width="111" height="146"></td>
                    <td>
                        <input type="radio" name="status${loop.count}" checked="checked" value="absent">absent
                        <input type="radio" name="status${loop.count}" value="present">present
                    </td>
                    <td>
                        <input id="note1" type="text" name="note${loop.count}">
                    </td>
                    <input type="hidden" value="${now}" name="recordTime">
                    <input type="hidden" value="${requestScope.sid}" name="sessionId">
                    </tr>
                </c:forEach>
            </table>
            <input style="margin-left: 1480px" type="submit" value="Take">
        </form>
    </body>
</html>
