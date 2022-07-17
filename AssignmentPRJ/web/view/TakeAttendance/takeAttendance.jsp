<%-- 
    Document   : takeAttendance
    Created on : Jul 17, 2022, 7:39:50 PM
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
        </style>
    </head>
    <body>
        <h1>Lecturer: ${sessionScope.account.userid}</h1>
        <h2>
            <c:if test="${requestScope.nowDate.getDay() eq 0}">Sunday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 1}">Monday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 2}">Tuesday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 3}">Wednesday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 4}">Thursday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 5}">Friday, </c:if>
            <c:if test="${requestScope.nowDate.getDay() eq 6}">Saturday, </c:if>
            ${requestScope.nowDate.getDate()}/${requestScope.nowDate.getMonth()+1}/${requestScope.nowDate.getYear()+1900}
        </h2>
        <table border="1px solid black">
            <tr>
                <th>No</th>
                <th>Course</th>
                <th>Session Number</th>
                <th>Group</th>
                <th>Slot</th>
                <th>Room</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${requestScope.sessions}" var="ss" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${ss.key.getGroup().getCourse().getId()}</td>
                    <td>${ss.key.getNumber()}</td>
                    <td>${ss.key.getGroup().getName()}</td>
                    <td>${ss.key.getSlot().getId()}</td>
                    <td>${ss.key.getRoomId().getId()}</td>
                    <td>
                        <c:if test="${ss.value eq 'Take'}">
                            <form action="gr_attendance" method="GET">
                                <input type="submit" name="" value="Take">
                                <input type="hidden" name="groupid" value="${ss.key.getGroup().getId()}">
                                <input type="hidden" name="sessionId" value="${ss.key.getId()}">
                            </form>
                        </c:if>
                        <c:if test="${ss.value eq 'View'}">
                            <form action="singleattendance" method="POST">
                                <input type="submit" name="" value="View">
                                <input type="hidden" name="sessionId" value="${ss.key.getId()}">
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
