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
import model.Lecturer;

/**
 *
 * @author trung
 */
public class LecturerDBContext extends DBContext<Lecturer> {

    public LecturerDBContext() {
    }

    @Override
    public ArrayList<Lecturer> list() {
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        try {
            String sql = "select LecturerID, LecturerName, Email from Lecturer";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecturer l = new Lecturer();
                l.setId(rs.getString("LecturerID"));
                l.setName(rs.getNString("LecturerName"));
                l.setEmail(rs.getString("Email"));
                lecturers.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lecturers;
    }

    public Lecturer get(String id) {
        try {
            String sql = "select LecturerName, Email from Lecturer\n"
                    + "where LecturerID = '"+ id +"'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Lecturer l = new Lecturer();
                l.setId(id);
                l.setName(rs.getNString("LecturerName"));
                l.setEmail(rs.getString("Email"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) {
//        LecturerDBContext lcd = new LecturerDBContext();
//        ArrayList<Lecturer> lects = lcd.list();
//        for (Lecturer lect : lects) {
//            System.out.println(lect.toString());
//        }
//        Lecturer l = lcd.get("sonnt5");
//        System.out.println(l.getName());
//    }
}
