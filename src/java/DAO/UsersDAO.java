/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODEL.User;
import jakarta.ws.rs.PathParam;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface UsersDAO {

    public List<User> getUsers();

    public User getUserByID(@PathParam("id") int id);
//    public List<User> getAllProductXML();
//
//    public List<User> getAllProductJSON();

}
