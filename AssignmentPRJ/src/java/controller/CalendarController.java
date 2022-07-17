/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javaprocess.DateCalculator;
import model.Session;
import model.TimeSlot;
import model.Week;

/**
 *
 * @author trung
 */
public class CalendarController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //process date
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
        ArrayList<Date> dateWeek = new ArrayList<>();
        dateWeek.add(nowWeek.getMon());
        dateWeek.add(nowWeek.getTue());
        dateWeek.add(nowWeek.getWed());
        dateWeek.add(nowWeek.getThu());
        dateWeek.add(nowWeek.getFri());
        dateWeek.add(nowWeek.getSat());
        dateWeek.add(nowWeek.getSun());

        request.getSession().setAttribute("sYear", thisYear);
        request.setAttribute("dateWeek", dateWeek);
        request.setAttribute("nowWeek", nowWeek);
        request.setAttribute("years", years);
        request.setAttribute("nowYear", thisYear);
        request.setAttribute("weeks", weeks);
        request.setAttribute("nowId", nowWeekId);
        
        //process database
        TimeSlotDBContext tsdc = new TimeSlotDBContext();
        SessionDBContext sdc = new SessionDBContext();
        ArrayList<TimeSlot> slots = tsdc.list();
        ArrayList<Session> sessions = sdc.listByWeek(nowWeek.getMon(), nowWeek.getSun());
        
        request.setAttribute("slots", slots);
        request.setAttribute("sessions", sessions);
        
        //forward to .jsp
        request.getRequestDispatcher("view/Calendar/calendar.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //process date
        DateCalculator dc = new DateCalculator();
        Calendar c = Calendar.getInstance();
        int thisYear = c.getTime().getYear() + 1900;
        int[] year = {thisYear - 3, thisYear - 2, thisYear - 1, thisYear, thisYear + 1};
        ArrayList<Integer> years = new ArrayList<>();
        for (int i = 0; i < year.length; i++) {
            years.add(year[i]);
        }
        ArrayList<Week> weeks;

        String raw_getYear = request.getParameter("year");
        String raw_getWeek = request.getParameter("week");

        int getYear;
        int getWeek;
        int nowWeekId;
        Week nowWeek;

        if (raw_getYear != null) {
            getYear = Integer.parseInt(raw_getYear);
            if (getYear == (c.getTime().getYear() + 1900)) {
                nowWeekId = dc.getWeekId();
            }
            else {
                nowWeekId = 1;
            }
            request.getSession().setAttribute("sYear", getYear);
        }
        else {
            getYear = (int) request.getSession().getAttribute("sYear");
            getWeek = Integer.parseInt(raw_getWeek);
            nowWeekId = getWeek;
        }
        weeks = dc.list(getYear);
        nowWeek = dc.getWeekById(nowWeekId, getYear);
        ArrayList<Date> dateWeek = new ArrayList<>();
        dateWeek.add(nowWeek.getMon());
        dateWeek.add(nowWeek.getTue());
        dateWeek.add(nowWeek.getWed());
        dateWeek.add(nowWeek.getThu());
        dateWeek.add(nowWeek.getFri());
        dateWeek.add(nowWeek.getSat());
        dateWeek.add(nowWeek.getSun());
        
        request.setAttribute("nowWeek", nowWeek);
        request.setAttribute("dateWeek", dateWeek);
        request.setAttribute("years", years);
        request.setAttribute("nowYear", getYear);
        request.setAttribute("weeks", weeks);
        request.setAttribute("nowId", nowWeekId);
        
        //process database
        TimeSlotDBContext tsdc = new TimeSlotDBContext();
        SessionDBContext sdc = new SessionDBContext();
        ArrayList<TimeSlot> slots = tsdc.list();
        ArrayList<Session> sessions = sdc.listByWeek(nowWeek.getMon(), nowWeek.getSun());
        
        request.setAttribute("slots", slots);
        request.setAttribute("sessions", sessions);
        
        //forward to .jsp
        request.getRequestDispatcher("view/Calendar/calendar.jsp").forward(request, response);
    }

}
