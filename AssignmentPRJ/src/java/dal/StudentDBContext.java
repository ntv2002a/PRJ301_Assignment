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
import model.Student;

/**
 *
 * @author trung
 */
public class StudentDBContext extends DBContext<Student> {

    public StudentDBContext() {
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select StudentID, MemberCode, LastName, MiddleName, FirstName from Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("StudentID"));
                s.setCode(rs.getString("MemberCode"));
                s.setLastName(rs.getNString("LastName"));
                s.setMiddleName(rs.getNString("MiddleName"));
                s.setFirstName(rs.getNString("FirstName"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

//    public static void main(String[] args) {
//        StudentDBContext sdc = new StudentDBContext();
//        ArrayList<Student> students = sdc.list();
//        for(Student s: students) {
//            System.out.println(s.toString());
//        }
//    }
    public Student get(String id) {
        try {
            String sql = "select MemberCode, LastName, MiddleName, FirstName from Student\n"
                    + "where StudentID = '" + id + "'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(id);
                s.setCode(rs.getString("MemberCode"));
                s.setLastName(rs.getNString("LastName"));
                s.setMiddleName(rs.getNString("MiddleName"));
                s.setFirstName(rs.getNString("FirstName"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
