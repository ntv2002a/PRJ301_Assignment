/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author trung
 */
public class Week {
    private int id;
    private Date Mon;
    private Date Tue;
    private Date Wed;
    private Date Thu;
    private Date Fri;
    private Date Sat;
    private Date Sun;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMon() {
        return Mon;
    }

    public void setMon(Date Mon) {
        this.Mon = Mon;
    }

    public Date getTue() {
        return Tue;
    }

    public void setTue(Date Tue) {
        this.Tue = Tue;
    }

    public Date getWed() {
        return Wed;
    }

    public void setWed(Date Wed) {
        this.Wed = Wed;
    }

    public Date getThu() {
        return Thu;
    }

    public void setThu(Date Thu) {
        this.Thu = Thu;
    }

    public Date getFri() {
        return Fri;
    }

    public void setFri(Date Fri) {
        this.Fri = Fri;
    }

    public Date getSat() {
        return Sat;
    }

    public void setSat(Date Sat) {
        this.Sat = Sat;
    }

    public Date getSun() {
        return Sun;
    }

    public void setSun(Date Sun) {
        this.Sun = Sun;
    }

    @Override
    public String toString() {
        return Mon.getDate() + "/" + (Mon.getMonth()+1) + " To " + Sun.getDate() + "/" + (Sun.getMonth()+1);
    }
    
    
}
