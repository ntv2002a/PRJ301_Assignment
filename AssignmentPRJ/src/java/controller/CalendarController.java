/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import javaprocess.DateCalculator;
import model.Week;

/**
 *
 * @author trung
 */
public class CalendarController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateCalculator dc = new DateCalculator();
        Calendar c = Calendar.getInstance();
        int thisYear = c.getTime().getYear() + 1900;
        int[] year = {thisYear - 3, thisYear - 2, thisYear - 1, thisYear, thisYear + 1};
        ArrayList<Integer> years = new ArrayList<>();
        for (int i = 0; i < year.length; i++) {
            years.add(year[i]);
        }
        ArrayList<Week> weeks = dc.list(thisYear);
        int nowWeekId = dc.getWeekId();
        Week nowWeek = dc.getWeekById(nowWeekId, thisYear);
        
        
        request.setAttribute("nowWeek", nowWeek);
        request.setAttribute("years", years);
        request.setAttribute("nowYear", thisYear);
        request.setAttribute("weeks", weeks);
        request.setAttribute("nowId", nowWeekId);
        request.getRequestDispatcher("view/Calendar/calendar.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         
        request.getRequestDispatcher("view/Calendar/calendar.jsp").forward(request, response);
    }

}
