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
import model.Attendance;
import model.Group;
import model.Lecturer;
import model.Session;
import model.Student;

/**
 *
 * @author trung
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    @Override
    public ArrayList<Attendance> list() {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select StudentID, SessionID, [Status], RecordTime, Note from Attendance";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                StudentDBContext stdc = new StudentDBContext();
                Student st = stdc.get(rs.getString("StudentID"));
                a.setStudent(st);
                SessionDBContext sdc = new SessionDBContext();
                Session s = sdc.get(rs.getInt("SessionID"));
                a.setSession(s);
                a.setStatus(rs.getString("Status"));
                a.setRecordTime(rs.getTimestamp("RecordTime"));
                a.setNote(rs.getString("Note"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }

    public ArrayList<Attendance> listBySessionID(int id) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select a.StudentID, st.LastName, st.MiddleName, st.FirstName, "
                    + "a.SessionID, a.[Status], a.RecordTime, a.Note, s.SessionNumber, \n"
                    + "s.LecturerID, s.Semester, s.SessionDate, s.GroupID, g.GroupName\n"
                    + "from Attendance a Inner join [Session] s\n"
                    + "on a.SessionID = s.SessionID\n"
                    + "inner join [Group] g \n"
                    + "on g.GroupID = s.GroupID\n"
                    + "inner join [Student] st\n"
                    + "on st.StudentID = a.StudentID\n"
                    + "where s.SessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                Student st = new Student();
                st.setId(rs.getString("StudentID"));
                st.setLastName(rs.getNString("LastName"));
                st.setMiddleName(rs.getNString("MiddleName"));
                st.setFirstName(rs.getNString("FirstName"));
                a.setStudent(st);
                Session s = new Session();
                s.setId(rs.getInt("SessionID"));
                s.setNumber(rs.getInt("SessionNumber"));
                Lecturer l = new Lecturer();
                l.setId(rs.getString("LecturerID"));
                s.setDate(rs.getDate("SessionDate"));
                s.setSemester(rs.getString("Semester"));
                Group g = new Group();
                g.setId(rs.getInt("GroupID"));
                g.setName(rs.getString("GroupName"));
                s.setGroup(g);
                s.setLecturer(l);
                a.setSession(s);
                a.setStatus(rs.getString("Status"));
                a.setRecordTime(rs.getTimestamp("RecordTime"));
                a.setNote(rs.getString("Note"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }

    public boolean isAttendanceExist(int sessionId) {
        try {
            String sql = "select StudentID, SessionID, [Status], RecordTime, Note from Attendance "
                    + "where SessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceDBContext adc = new AttendanceDBContext();
        ArrayList<Attendance> attendances = adc.listBySessionID(1);
        for (Attendance a : attendances) {
            System.out.println(a.getStudent().getId());
        }
    }

}
