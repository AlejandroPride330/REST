/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import MODEL.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class UserDaoImplements implements AutoCloseable {

    public static final String URL = "jdbc:mariadb://localhost:3306/dev";
    public static final String USER = "root";
    public static final String PASS = "sonicblow";
    public static Connection con = null;

    public static Connection conexion() throws Exception {

        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new Exception("Error de conexión a la base de datos");
        }
        return con;
    }

    public static void cerrar() throws Exception {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new Exception("No se ha podido cerrar la conexión a la base de datos");
        }
    }

    public static List<User> getUsers() throws Exception {
        String resultado = "";
        String sql = "SELECT * FROM user ";
        List<User> users = new ArrayList<User>();
        try (PreparedStatement pstmt = conexion().prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setRol(rs.getString("rol"));
                user.setYearBirth(rs.getInt("yearBirth"));
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en la consulta");
        }
        return users;
    }

    public static User getUserByID(int id) throws Exception {
        String resultado = "";
        String sql = "SELECT * FROM user Where id = ?";
        User user = null;
        try (PreparedStatement pstmt = conexion().prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

            pstmt.setInt(1, id);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setRol(rs.getString("rol"));
                user.setYearBirth(rs.getInt("yearBirth"));
            }
        } catch (SQLException ex) {
            throw new Exception("Error en la consulta");
        }
        return user;
    }

    public static List<User> getUserByYearBirth(int yearBirth) throws Exception {
        String resultado = "";
        String sql = "SELECT * FROM user Where yearBirth = ?";
        User user = null;
        List<User> users = new ArrayList<User>();
        try (PreparedStatement pstmt = conexion().prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

            pstmt.setInt(1, yearBirth);

            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setRol(rs.getString("rol"));
                user.setYearBirth(rs.getInt("yearBirth"));
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new Exception("Error en la consulta");
        }
        return users;
    }
    public  boolean insertUser(User user){
         String sql = "INSERT INTO users (id, name, rol, yearBirth) VALUES (?, ?, ?, ?)";
         boolean r= true;
        try ( PreparedStatement stm = conexion().prepareStatement(sql);) {
              
            stm.setString(1, user.getId());
            stm.setString(2, user.getName());
            stm.setString(3, user.getRol());
            stm.setInt(4, user.getYearBirth());
            stm.executeUpdate();
            System.out.println("User insertado en la tabla satisfactoriamente");
            return r;
        } catch (NumberFormatException nf) {
            System.out.println("YearBirth debe ser un numero.");
            return false;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
