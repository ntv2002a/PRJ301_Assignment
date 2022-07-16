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
import model.Session;
import model.Student;

/**
 *
 * @author trung
 */
public class AttendanceDBContext extends DBContext<Attendance>{

    @Override
    public ArrayList<Attendance> list() {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select StudentID, SessionID, [Status], RecordTime, Note from Attendance";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
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
    
    public ArrayList<Attendance> listBySession(int id) {
        return null;
    }
            
}