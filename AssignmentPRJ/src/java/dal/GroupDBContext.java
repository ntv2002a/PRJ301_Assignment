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
import model.Course;
import model.Group;
import model.Lecturer;
import model.Student;

/**
 *
 * @author trung
 */
public class GroupDBContext extends DBContext<Group> {

    @Override
    public ArrayList<Group> list() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select GroupID, GroupName, LecturerID, CourseID from [Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setId(rs.getInt("GroupID"));
                g.setName(rs.getString("GroupName"));
                LecturerDBContext ldc = new LecturerDBContext();
                Lecturer l = ldc.get(rs.getString("LecturerID"));
                g.setLecturer(l);
                CourseDBContext cdc = new CourseDBContext();
                Course c = cdc.get(rs.getString("CourseID"));
                g.setCourse(c);
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }

//    public static void main(String[] args) {
//        GroupDBContext gdc = new GroupDBContext();
//        ArrayList<Group> groups = gdc.list();
//        for (Group group : groups) {
//            System.out.println(group.getCourse().getName());
//        }
//    }
    public Group get(int id) {
        try {
            String sql = "select GroupName, LecturerID, CourseID from [Group]\n"
                    + "where GroupID = '" + id + "'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setId(id);
                g.setName(rs.getString("GroupName"));
                LecturerDBContext ldc = new LecturerDBContext();
                Lecturer l = ldc.get(rs.getString("LecturerID"));
                g.setLecturer(l);
                CourseDBContext cdc = new CourseDBContext();
                Course c = cdc.get(rs.getString("CourseID"));
                g.setCourse(c);
                ArrayList<Student> students = getListStudent(id);
                g.setStudents(students);
                return g;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> getListStudent(int id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select StudentID from StudentGroup\n"
                    + "where GroupID = " + id;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StudentDBContext sdc = new StudentDBContext();
                Student s = sdc.get(rs.getString("StudentID"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}
