<%-- 
    Document   : Attendance
    Created on : Jul 16, 2022, 9:17:59 PM
    Author     : trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css">
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
        <h1>Single activity Attendance</h1>
        <h2>Attendance for ${requestScope.session.getGroup().getCourse().getId()}
            with lecturer ${sessionScope.account.userid}
            at slot ${requestScope.session.getSlot().getId()} on 
            <c:if test="${requestScope.session.getDate().getDay() eq 0}">Sunday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 1}">Monday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 2}">Tuesday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 3}">Wednesday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 4}">Thursday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 5}">Friday</c:if>
            <c:if test="${requestScope.session.getDate().getDay() eq 6}">Saturday</c:if>
            ${requestScope.session.getDate().getDate()}/${requestScope.session.getDate().getMonth()+1}/${requestScope.session.getDate().getYear()+1900}, 
            ${requestScope.session.getSemester()}, in room ${requestScope.session.getRoomId().getId()}
        </h2>
        <table border="1px solid black">
            <tr>
                <th>No</th>
                <th>Group</th>
                <th>Code</th>
                <th>Name</th>
                <th>Image</th>
                <th>Status</th>
                <th>Note</th>
                <th>Taker</th>
                <th>Record Time</th>
            </tr>
            <c:forEach items="${requestScope.attendances}" var="a" varStatus="loop" >
                <tr>
                    <td>${loop.count}</td>
                    <td>${a.getSession().getGroup().getName()}</td>
                    <td>${a.getStudent().getId()}</td>
                    <td>${a.getStudent().getFullname()}</td>
                    <td><img src="image/${a.getStudent().getId()}.jpg" width="111" height="146"></td>
                    <td ${a.getStatus().equals("absent")?"style='color: red'":"style='color: green'"}>${a.getStatus()}</td>
                    <td>${a.getNote()}</td>
                    <td>${a.getSession().getLecturer().getId()}</td>
                    <td>${a.getRecordTime().toString()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
