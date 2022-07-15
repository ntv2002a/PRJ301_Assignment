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
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author trung
 */
public class SessionDBContext extends DBContext<Session>{

    @Override
    public ArrayList<Session> list() {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select SessionID, SessionNumber, LecturerID, Semester, SessionDate, GroupID, SlotID, RoomID from [Session]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("SessionID"));
                s.setNumber(rs.getInt("SessionNumber"));
                LecturerDBContext ldc = new LecturerDBContext();
                Lecturer l = ldc.get(rs.getString("LecturerID"));
                s.setLecturer(l);
                s.setSemester(rs.getString("Semester"));
                s.setDate(rs.getDate("SessionDate"));
                GroupDBContext gdc = new GroupDBContext();
                Group g = gdc.get(rs.getInt("GroupID"));
                s.setGroup(g);
                TimeSlotDBContext tdc = new TimeSlotDBContext();
                TimeSlot t = tdc.get(rs.getInt("SlotID"));
                s.setSlot(t);
                RoomDBContext rdc = new RoomDBContext();
                Room r = rdc.get(rs.getString("RoomID"));
                s.setRoomId(r);
                sessions.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }
    
}
