/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaprocess.DateCalculator;
import model.Course;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.TimeSlot;
import model.Week;

/**
 *
 * @author trung
 */
public class SessionDBContext extends DBContext<Session> {

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

    public Session get(int id) {
        try {
            String sql = "select s.SessionNumber, s.Semester, s.SessionDate, s.SlotID, s.RoomID, c.CourseID from [Session] s inner join [Group] g\n"
                    + "on s.GroupID = g.GroupID inner join Course c\n"
                    + "on g.CourseID = c.CourseID\n"
                    + "where s.SessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(id);
                s.setNumber(rs.getInt("SessionNumber"));
                s.setSemester(rs.getString("Semester"));
                s.setDate(rs.getDate("SessionDate"));
                Group g = new Group();
                Course c = new Course();
                c.setId(rs.getString("CourseID"));
                g.setCourse(c);
                s.setGroup(g);
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("SlotID"));
                s.setSlot(t);
                Room r = new Room();
                r.setId(rs.getString("RoomID"));
                s.setRoomId(r);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Session> listByWeek(Date start, Date end, String lectureId) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select s.SessionID, s.SessionNumber, s.Semester, s.SessionDate, s.SlotID,\n"
                    + "s.RoomID, g.GroupID, g.GroupName, c.CourseID from [Session] s inner join [Group] g\n"
                    + "on s.GroupID = g.GroupID inner join [Course] c\n"
                    + "on g.CourseID = c.CourseID\n"
                    + "where s.SessionDate between ? and ?\n"
                    + "and s.LecturerID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, (start.getYear() + 1900) + "-" + (start.getMonth() + 1) + "-" + start.getDate());
            stm.setString(2, (end.getYear() + 1900) + "-" + (end.getMonth() + 1) + "-" + end.getDate());
            stm.setString(3, lectureId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("SessionID"));
                s.setNumber(rs.getInt("SessionNumber"));
                Lecturer l = new Lecturer();
                l.setId(lectureId);
                s.setLecturer(l);
                s.setSemester(rs.getString("Semester"));
                s.setDate(rs.getDate("SessionDate"));
                Group g = new Group();
                g.setId(rs.getInt("GroupID"));
                g.setName(rs.getString("GroupName"));
                Course c = new Course();
                c.setId(rs.getString("CourseID"));
                g.setCourse(c);
                s.setGroup(g);
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("SlotID"));
                s.setSlot(t);
                Room r = new Room();
                r.setId(rs.getString("RoomID"));
                s.setRoomId(r);
                sessions.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

//    public static void main(String[] args) {
//        SessionDBContext sdc = new SessionDBContext();
//        DateCalculator dc = new DateCalculator();
//        Week w = dc.getWeekById(19, 2022);
//        ArrayList<Session> sessions = sdc.listByWeek(w.getMon(), w.getSun());
//        for (Session session : sessions) {
//            System.out.println(session.getId());
//        }
//    }
}
