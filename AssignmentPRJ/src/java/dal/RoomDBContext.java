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
import model.Room;

/**
 *
 * @author trung
 */
public class RoomDBContext extends DBContext<Room> {

    public RoomDBContext() {
    }

    @Override
    public ArrayList<Room> list() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "select RoomID from Room";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getString("RoomID"));
                rooms.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

//    public static void main(String[] args) {
//        RoomDBContext rdc = new RoomDBContext();
//        ArrayList<Room> rooms = rdc.list();
//        for (Room room : rooms) {
//            System.out.println(room.toString());
//        }
//    }
    public Room get(String id) {
        try {
            String sql = "select RoomID from Room\n"
                    + "where RoomID = '" + id + "'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(id);
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
