<%-- 
    Document   : calendar
    Created on : Jul 16, 2022, 9:57:02 PM
    Author     : trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
        <script>
            function submitYClick() {
                document.getElementById("year").submit();
            }
            function submitWClick() {
                document.getElementById("week").submit();
            }
        </script>
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
        <div style="text-align: center;">Campus: FU-HL
        </div>
        <div style="text-align: center;">Lecturer: ${sessionScope.account.userid}
        </div>
        <br>
        <table border="1px solid black">
            <form action="Calendar" method="POST" id="year">
                <tr>
                    <th>Year <select name="year" onchange="submitYClick()">
                            <c:forEach items="${requestScope.years}" var="y" varStatus="loop">
                                <option value="${y}" <c:if test="${y eq requestScope.nowYear}">selected="selected"</c:if>  >${y}</option>
                            </c:forEach>
                        </select></th>

                    <th>Mon</th>
                    <th>Tue</th>
                    <th>Wed</th>
                    <th>Thu</th>
                    <th>Fri</th>
                    <th>Sat</th>
                    <th>Sun</th>
                </tr>
            </form>
            <form action="Calendar" method="POST" id="week">
                <tr>
                    <th>Week <select name="week" onchange="submitWClick()">
                            <c:forEach items="${requestScope.weeks}" var="w" varStatus="loop">
                                <option value="${w.id}" <c:if test="${w.id eq requestScope.nowId}">selected="selected"</c:if>>${w.toString()}</option>
                            </c:forEach>
                        </select></th>
                        <c:forEach items="${requestScope.dateWeek}" var="d" varStatus="loop">
                        <th>${d.getDate()}/${d.getMonth()+1}</th>
                        </c:forEach>
                </tr>
            </form>
            <c:forEach items="${requestScope.slots}" var="s" varStatus="loop">
                <tr>
                    <th>Slot ${s.id}</th>
                        <c:forEach items="${requestScope.dateWeek}" var="d" varStatus="loop">
                        <td><c:forEach items="${requestScope.sessions}" var="ss" varStatus="loop">
                                <c:if test="${(ss.key.getDate().getDate() eq d.getDate()) && (ss.key.getSlot().getId() eq s.id)}" >
                                    <form action="singleattendance" method="POST" id="session">
                                        <br>
                                        <input type="submit" value="${ss.key.getGroup().getCourse().getId()}">
                                        <br>
                                        <p>${ss.key.getGroup().getName()}</p>
                                        <p>at ${ss.key.getRoomId().getId()}</p>
                                        <p ${ss.value.equals("Not yet")?"style='color: red'":"style='color: green'"}>${ss.value}</p>
                                        <input type="hidden" value="${ss.key.getId()}" name="sessionId">
                                    </form>
                                </c:if>
                            </c:forEach></td>
                        </c:forEach>
                </tr>
            </c:forEach>    
        </table>


    </body>
</html>
