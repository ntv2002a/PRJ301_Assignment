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
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align: center;">Campus: FU-HL
        </div>
        <div style="text-align: center;">Lecturer: ${sessionScope.account.userid}
        </div>
        <table border="1px solid black">
            <tr>
                <td>Year <select name="year">
                        <c:forEach items="${requestScope.years}" var="y" varStatus="loop">
                            <option value="${y}" <c:if test="${y eq requestScope.nowYear}">selected="selected"</c:if>>${y}</option>
                        </c:forEach>
                    </select></td>
                <th>Mon</th>
                <th>Tue</th>
                <th>Wed</th>
                <th>Thu</th>
                <th>Fri</th>
                <th>Sat</th>
                <th>Sun</th>
            </tr>
            <tr>
                <td>Week <select name="week">
                        <c:forEach items="${requestScope.weeks}" var="w" varStatus="loop">
                            <option value="${y.id}" <c:if test="${w.id eq requestScope.nowId}">selected="selected"</c:if>>${w.toString()}</option>
                        </c:forEach>
                    </select></td>
                <th>${requestScope.nowWeek.getMon().getDate()}/${requestScope.nowWeek.getMon().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getTue().getDate()}/${requestScope.nowWeek.getTue().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getWed().getDate()}/${requestScope.nowWeek.getWed().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getThu().getDate()}/${requestScope.nowWeek.getThu().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getFri().getDate()}/${requestScope.nowWeek.getFri().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getSat().getDate()}/${requestScope.nowWeek.getSat().getMonth()+1}</th>
                <th>${requestScope.nowWeek.getSun().getDate()}/${requestScope.nowWeek.getSun().getMonth()+1}</th>
            </tr>
        </table>
    </body>
</html>
