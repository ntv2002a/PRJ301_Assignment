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
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import model.Account;
import model.Session;

/**
 *
 * @author trung
 */
public class TakeAttendanceController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionDBContext sdc = new SessionDBContext();
        Calendar c = Calendar.getInstance();
        String raw_date = (c.getTime().getYear() + 1900) + "-" + (c.getTime().getMonth() + 1) + "-" + (c.getTime().getDate());
        Date d = Date.valueOf(raw_date);
        Account acc = (Account) request.getSession().getAttribute("account");
        ArrayList<Session> sessions = sdc.listByDate(raw_date, acc.getUserid());
        AttendanceDBContext adc = new AttendanceDBContext();
        HashMap<Session, String> map = new HashMap<>();
        for (Session session : sessions) {
            if (!adc.isAttendanceExist(session.getId())) {
                map.put(session, "Take");
            }
            else {
                map.put(session, "View");
            }
        }

        request.setAttribute("nowDate", d);
        request.setAttribute("sessions", map);
        request.getRequestDispatcher("view/TakeAttendance/takeAttendance.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
