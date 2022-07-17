/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.GroupDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import model.Group;

/**
 *
 * @author trung
 */
public class GroupAttendance extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar c = Calendar.getInstance();
        String raw_id = request.getParameter("groupid");
        String raw_sid = request.getParameter("sessionId");
        
        int sessionId = Integer.parseInt(raw_sid);
        int groupId = Integer.parseInt(raw_id);
        GroupDBContext gdc = new GroupDBContext();
        Group g = gdc.get(groupId);
        String raw_time = c.getTime().getHours() + ":" + c.getTime().getMinutes() + ":" + c.getTime().getSeconds();
        Time time = Time.valueOf(raw_time);
        
        request.setAttribute("sid", sessionId);
        request.setAttribute("now", time);
        request.setAttribute("group", g);
        request.getRequestDispatcher("view/TakeAttendance/groupAttendance.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
}
