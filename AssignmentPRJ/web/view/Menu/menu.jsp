<%-- 
    Document   : menu
    Created on : Jul 17, 2022, 6:50:51 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial;
            }
            
            h1 {
                text-align: center;
            }
            
            input {
                width: 98%;
                height: 20%;
                font-size: 50px;
                margin: 20px 25px;
            }
        </style>
    </head>
    <body>
        <h1>Welcome ${sessionScope.account.userid}!</h1>
        
        <a href="Calendar">Schedule</a>
        <br>
        <a href="takeattendance">Take Attendance</a>
    </body>
</html>
