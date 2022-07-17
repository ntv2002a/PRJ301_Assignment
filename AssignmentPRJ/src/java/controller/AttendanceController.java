/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendanceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.ArrayList;
import model.Session;
import model.Attendance;
import model.Student;

/**
 *
 * @author trung
 */
public class AttendanceController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] count = request.getParameterValues("count");
        Session ss = new Session();
        String raw_sid = request.getParameter("sessionId");
        int sid = Integer.parseInt(raw_sid);
        ss.setId(sid);

        ArrayList<Attendance> attendances = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            Attendance a = new Attendance();
            a.setSession(ss);
            Student s = new Student();
            s.setId(request.getParameter("id_" + count[i]));
            a.setStudent(s);
            a.setStatus(request.getParameter("status" + count[i]));
            a.setNote(request.getParameter("note" + count[i]));
            a.setRecordTime(Time.valueOf(request.getParameter("recordTime")));
            attendances.add(a);
        }
        
        AttendanceDBContext adc = new AttendanceDBContext();
        adc.takeAttendances(attendances);
        
        response.sendRedirect("takeattendance");
    }

}
