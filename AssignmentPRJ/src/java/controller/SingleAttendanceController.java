/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import model.Attendance;
import model.Session;

/**
 *
 * @author trung
 */
public class SingleAttendanceController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/SingleAttendance/Attendance.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raw_id = request.getParameter("sessionId");
        int id = Integer.parseInt(raw_id);
        AttendanceDBContext adc = new AttendanceDBContext();
        ArrayList<Attendance> attendances = adc.listBySessionID(id);
        SessionDBContext sdc = new SessionDBContext();
        Session session = sdc.get(id);

        if (attendances.isEmpty()) {
            response.getWriter().println("Class hasn't started yet!");
        } else {
            request.setAttribute("session", session);
            request.setAttribute("attendances", attendances);
            request.getRequestDispatcher("view/SingleAttendance/Attendance.jsp").forward(request, response);
        }
    }

}
