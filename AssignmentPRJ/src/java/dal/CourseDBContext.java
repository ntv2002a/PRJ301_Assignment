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

/**
 *
 * @author trung
 */
public class CourseDBContext extends DBContext<Course>{

    public CourseDBContext() {
    }
    
    @Override
    public ArrayList<Course> list() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "select CourseID, CourseName from Course";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("CourseID"));
                c.setName("CourseName");
                courses.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
    
//    public static void main(String[] args) {
//        CourseDBContext cdc = new CourseDBContext();
//        ArrayList<Course> courses = cdc.list();
//        for (Course course : courses) {
//            System.out.println(course.getId());
//        }
//    }
    
}
