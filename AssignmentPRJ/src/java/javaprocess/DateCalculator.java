/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprocess;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Week;

/**
 *
 * @author trung
 */
public class DateCalculator {

    public ArrayList<Week> list(int year) {
        ArrayList<Week> weeks = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.set(year, 0, 1);
        if ((1 - c.getTime().getDay()) < 0) {
            c.add(Calendar.DATE, (7 + (1 - c.getTime().getDay())));
        } else {
            c.add(Calendar.DATE, 1 - c.getTime().getDay());
        }
        for (int i = 1; i <= 52; i++) {
            Week w = new Week();
            w.setId(i);
            w.setMon(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setTue(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setWed(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setThu(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setFri(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setSat(c.getTime());
            c.add(Calendar.DATE, 1);
            w.setSun(c.getTime());
            c.add(Calendar.DATE, 1);
            weeks.add(w);
        }
        return weeks;
    }

    public int getWeekId() {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        ArrayList<Week> weeks = list(now.getYear()+1900);
        int id = 0;
        for (Week week : weeks) {
            if (!now.after(week.getMon())) {
                break;
            }
            id = week.getId();
        }
        return id;
    }
    
    public Week getWeekById(int id, int year) {
        ArrayList<Week> weeks = list(year);
        for (Week week : weeks) {
            if (week.getId() == id) {
                Week w = week;
                return w;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DateCalculator d = new DateCalculator();
        System.out.println(d.getWeekById(2, 2022));
    }
}
