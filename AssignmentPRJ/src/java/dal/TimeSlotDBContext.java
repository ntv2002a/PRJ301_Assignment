/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TimeSlot;

/**
 *
 * @author trung
 */
public class TimeSlotDBContext extends DBContext<TimeSlot>{

    public TimeSlotDBContext() {
    }
    
    @Override
    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> timeSlots = new ArrayList<>();
        try {
            String sql = "select SlotID, TimeStart, TimeEnd from TimeSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("SlotID"));
                t.setStart(rs.getTime("TimeStart"));
                t.setEnd(rs.getTime("TimeEnd"));
                timeSlots.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeSlots;
    }
    
//    public static void main(String[] args) {
//        TimeSlotDBContext tdc = new TimeSlotDBContext();
//        ArrayList<TimeSlot> slots = tdc.list();
//        for (TimeSlot slot : slots) {
//            System.out.println(slot.toString());
//        }
//    }
}
