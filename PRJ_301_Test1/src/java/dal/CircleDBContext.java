/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import object.Circles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class CircleDBContext extends DBContext<Circles> {

    @Override
    public ArrayList<Circles> list() {
        ArrayList<Circles> circles = new ArrayList<>();
        try {
            String sql = "SELECT id,x,y,radius FROM Circle";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Circles c = new Circles();
                c.setId(rs.getInt("id"));
                c.setX(rs.getInt("x"));
                c.setY(rs.getInt("y"));
                c.setRadius(rs.getInt("radius"));
                circles.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CircleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CircleDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return circles;
    }

    @Override
    public Circles get(int id, ArrayList<Circles> c) {
        for (int i = 0; i<c.size(); i++) {
            if (c.get(i).getId() == id) {
                return c.get(i);
            }
        }
        return null;
    }

    @Override
    public void insert(Circles model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Circles model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Circles model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
